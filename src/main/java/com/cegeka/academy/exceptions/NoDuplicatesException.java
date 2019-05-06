package com.cegeka.academy.exceptions;

public class NoDuplicatesException extends RuntimeException{
    public NoDuplicatesException(String errorMessage){
        super(errorMessage);
    }
}
