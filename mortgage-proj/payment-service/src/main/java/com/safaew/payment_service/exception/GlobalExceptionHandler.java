package com.safaew.payment_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationValidationException.class)
    public ResponseEntity<ErrorMessage> handleAppValidationException(ApplicationValidationException exception){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(exception.getMessage());

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

    }
}
