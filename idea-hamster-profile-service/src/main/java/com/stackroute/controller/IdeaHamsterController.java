package com.stackroute.controller;


import com.stackroute.IdeaHamsterProfileServiceApplication;
import com.stackroute.domain.IdeaHamster;
import com.stackroute.dto.IdeaHamsterDto;
import com.stackroute.exception.UserAlreadyFoundException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.service.IdeaHamsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController
/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping("api/v1")
public class  IdeaHamsterController {

    private IdeaHamsterService ideaHamsterService;

    /**
     * Constructor based Dependency injection to inject TrackService into controller
     */
    @Autowired
    public IdeaHamsterController(IdeaHamsterService ideaHamsterService) {
        this.ideaHamsterService = ideaHamsterService;
    }

    /**
     * PostMapping Annotation for mapping HTTP POST requests onto specific handler methods.
     */
    @PostMapping("ihdto")
    public ResponseEntity<?> saveTheUser(@RequestBody IdeaHamsterDto provider) throws Exception,UserAlreadyFoundException{

        return new ResponseEntity<>(ideaHamsterService.saveIdeaHamster(provider), HttpStatus.CREATED);

    }

    /**
     * GetMapping Annotation for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("ideahamster/{email}")
    public ResponseEntity<?> getTheUser(@PathVariable ("email") String email) throws Exception {
        return new ResponseEntity<IdeaHamster>(ideaHamsterService.getTheProfile(email), HttpStatus.OK);

    }

    /**
     * PutMapping Annotation for mapping HTTP PuT requests onto specific handler methods.
     */
    @PutMapping("ideahamster")
    public ResponseEntity<?> updateTheUser(@RequestBody IdeaHamster ideaHamster) throws Exception, UserNotFoundException {
        return new ResponseEntity<>(ideaHamsterService.updateTheProfile(ideaHamster), HttpStatus.OK);
    }
}
