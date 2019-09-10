package com.stackroute.userloginservice.controller;

import com.stackroute.userloginservice.service.UserServiceImpl;
import com.stackroute.userloginservice.domain.User;

import com.stackroute.userloginservice.exception.PasswordNotMatchException;
import com.stackroute.userloginservice.exception.EmailIdNotFoundException;
import com.stackroute.userloginservice.exception.EmailIdOrPasswordEmptyException;
import com.stackroute.userloginservice.jwt.SecurityTokenGenrator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/* @RestController = @Controller + @ResponseBody */

@CrossOrigin(value = "*")
@RequestMapping("api/v1")
@RestController
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {

        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?>  login(@RequestBody User loginDetails) throws EmailIdOrPasswordEmptyException, EmailIdNotFoundException, PasswordNotMatchException,Exception{

        String emailId = loginDetails.getEmailId();

        String password = loginDetails.getPassword();

//        String emailID= loginDetails.getEmailId();
        System.out.println(emailId);
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        if (!emailId.matches(regex))
        {
            throw new Exception(("EmailId entered by you is not proper!!!"));
        }


        if (emailId == null || password == null) {

            throw new EmailIdOrPasswordEmptyException();
        }

        User user = userService.findByEmailIdAndPassword(emailId,password);

        if (user == null) {
            throw new EmailIdNotFoundException();
        }



        String fetchedPassword = user.getPassword();

        if (!password.equals(fetchedPassword)) {
            throw new PasswordNotMatchException();
        }

        // generating token

        SecurityTokenGenrator securityTokenGenrator = (User userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId(""+user.getEmailId()).setIssuedAt(new Date()).setSubject(user.getRole())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();

            map1.put("token", jwtToken);

            map1.put("message", "User successfully logged in");

            return map1;

        };
        Map<String, String> map = securityTokenGenrator.generateToken(user);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

}

