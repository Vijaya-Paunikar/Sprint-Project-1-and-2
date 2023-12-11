package com.example.exception;

public class CloudUserNotFoundException extends RuntimeException {
    public CloudUserNotFoundException(String message) {
        super(message);
    }
}
