package com.interview.exception;

public class InvalidLastNameException extends IllegalArgumentException{
    public InvalidLastNameException(){
        super ("The last name is invalid. It has to be at least 5 characters long and max 10 characters long.");
    }
}
