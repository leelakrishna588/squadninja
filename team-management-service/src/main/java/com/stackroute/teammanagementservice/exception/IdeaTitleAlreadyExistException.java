package com.stackroute.teammanagementservice.exception;

public class IdeaTitleAlreadyExistException extends Exception {
    private String message;

    public IdeaTitleAlreadyExistException() {

    }

    public IdeaTitleAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
