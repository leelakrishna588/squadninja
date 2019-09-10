package com.stackroute.userloginservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloballyExceptionHandler {

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<?> handlePasswordNotMatchException(PasswordNotMatchException e){
        return new ResponseEntity<String>("Password Doesn't Match !", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailIdNotFoundException.class)
    public ResponseEntity<?> handleUserNameNotFoundException(EmailIdNotFoundException e){
        return new ResponseEntity<String>("Email Id Not Found !", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailIdOrPasswordEmptyException.class)
    public ResponseEntity<?> handleUserNameOrPasswordEmptyException(EmailIdOrPasswordEmptyException e){
        return new ResponseEntity<String>("User Email Id/Password is Empty !", HttpStatus.NOT_FOUND);
    }


}
