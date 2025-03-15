package com.safaew.payment_service.exception;

public class ApplicationValidationException extends RuntimeException{
    public ApplicationValidationException(String message) {
        super(message);
    }
}
