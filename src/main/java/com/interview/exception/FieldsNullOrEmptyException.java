package com.interview.exception;


public class FieldsNullOrEmptyException extends IllegalArgumentException{

    public FieldsNullOrEmptyException(){
        super("One or more of your fields are null and/or empty. Please look over your request and try again");
    }
}
