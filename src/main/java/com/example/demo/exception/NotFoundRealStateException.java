package com.example.demo.exception;

public class NotFoundRealStateException extends RuntimeException {
    public NotFoundRealStateException(String message) {
        super(message);
    }
}
