package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    /**
     * Handles UserAlreadyExistsException
     */
    @ExceptionHandler(value = UserAlreadyFoundException.class)
    public ResponseEntity<Object> alreadyExistsException(final UserAlreadyFoundException e) {
        return new ResponseEntity<>("User Already Exists", HttpStatus.CONFLICT);
    }

    /**
     * Handles UserNotFoundException
     */
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> notFoundException(final UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles Internal_Server_Error i.e if database connection fails
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>("Database connectivity is lost", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
