package com.interview.exception;

public class InvalidAgeException extends IllegalArgumentException{
    public InvalidAgeException(){
        super("The age you have entered is below 18 years of age.");
    }
}
