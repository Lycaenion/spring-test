package com.interview.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ValidationExceptionAdvice {

    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<String> inputNotValidHandler(FieldsNullOrEmptyException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<String> invalidLastNameHandler(InvalidLastNameException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<String> invalidAgeHandler(InvalidAgeException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
