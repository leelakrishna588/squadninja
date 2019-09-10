package com.stackroute.ideahamsterpostingidea.exception;

/**
 * Custom Exception to throw if idea already exists
 */
public class IdeaAlreadyExistException extends Exception {
  private String message;

  public IdeaAlreadyExistException() {
  }

  public IdeaAlreadyExistException(String message) {
    super(message);
    this.message = message;
  }
}
