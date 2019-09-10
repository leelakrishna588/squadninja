package com.stackroute.exception;

public class UserAlreadyFoundException extends Exception {

    private String message;

    public UserAlreadyFoundException(String message) {
        super(message);
        this.message = message;
    }
}
