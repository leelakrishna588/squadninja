package com.stackroute.controller;


import com.stackroute.domain.ServiceProvider;
import com.stackroute.dto.ServiceProviderDto;
import com.stackroute.exception.UserAlreadyFoundException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class ServiceProviderController {

    private ServiceProviderService serviceProviderService;


    /**
     * Constructor based Dependency injection to inject TrackService into controller
     */
    @Autowired
    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;

    }

    /**
     * PostMapping Annotation for mapping HTTP POST requests onto specific handler methods.
     */
    @PostMapping("serviceprovider")
    public ResponseEntity<?> saveTheUser(@RequestBody ServiceProviderDto serviceProviderDto) throws UserAlreadyFoundException {

        return new ResponseEntity<>(serviceProviderService.saveServiceProvider(serviceProviderDto), HttpStatus.CREATED);

    }

    /**
     * GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
     */

    @GetMapping("serviceprovider/{email}")
    public ResponseEntity<?> getTheUser(@PathVariable("email") String email) throws UserNotFoundException {
        return new ResponseEntity<ServiceProvider>(serviceProviderService.getTheProfile(email),HttpStatus.OK);

    }

    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     */
    @PutMapping("serviceprovider")
    public ResponseEntity<?> updateTheUser(@RequestBody ServiceProvider provider) throws Exception {
        System.out.println(provider.toString());
        return new ResponseEntity<ServiceProvider>(serviceProviderService.updateTheProfile(provider),HttpStatus.OK);

    }


}
