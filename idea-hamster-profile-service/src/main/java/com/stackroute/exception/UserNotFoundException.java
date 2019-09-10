package com.stackroute.exception;
/**
 * Custom Exception to throw if track is not found
 */
public class UserNotFoundException extends Exception{


    private String message;

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public UserNotFoundException() {
    }
}

