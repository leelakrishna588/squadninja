package com.stackroute.teammanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(IdeaTitleAlreadyExistException.class)
    public ResponseEntity<?> titleAlreadyExists(IdeaTitleAlreadyExistException ex){
        return new ResponseEntity<String>("Title Alreday Exists", HttpStatus.CONFLICT);
    }
}
