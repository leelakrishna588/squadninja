package com.stackroute.ideahamsterpostingidea.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*@ControllerAdvice is an annotation provided by Spring allowing you to write global code that can be applied
to a wide range of controllers — varying from all controllers to a chosen package or even a specific annotation.*/
@ControllerAdvice
public class GlobalExceptions {
  /*@ExceptionHandler allows you to define a method that, as the name suggests, handles exceptions*/
  @ExceptionHandler(IdeaNotFoundException.class)
  public ResponseEntity<?> notFoundException(final IdeaNotFoundException e) {
    return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  /*@ExceptionHandler allows you to define a method that, as the name suggests, handles exceptions*/
  @ExceptionHandler(IdeaAlreadyExistException.class)
  public ResponseEntity<?> alreadyExistException(final IdeaAlreadyExistException e) {
    return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
  }
  /*@ExceptionHandler allows you to define a method that, as the name suggests, handles exceptions*/
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> exception( final Exception e){
    return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
