package com.cegeka.academy.exceptions;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String mesaj) {
        super(mesaj);
    }
}
