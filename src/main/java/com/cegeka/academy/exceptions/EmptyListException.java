package com.cegeka.academy.exceptions;

public class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage){
        super(errorMessage);
    }

}
