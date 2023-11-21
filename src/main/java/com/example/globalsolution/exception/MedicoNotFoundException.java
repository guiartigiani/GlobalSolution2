package com.example.globalsolution.exception;

public class MedicoNotFoundException extends RuntimeException {
    public MedicoNotFoundException(String message) {
        super(message);
    }
}
