package com.example.demo.exception;

public class BusinessServiceException extends RuntimeException {

    private String message;

    public BusinessServiceException(String message) {
        super(message);
        this.message = message;
    }

}
