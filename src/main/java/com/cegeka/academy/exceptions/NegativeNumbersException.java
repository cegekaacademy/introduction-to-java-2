package com.cegeka.academy.exceptions;

public class NegativeNumbersException extends RuntimeException {
    public NegativeNumbersException(String errorMessage){
        super(errorMessage);
    }
}
