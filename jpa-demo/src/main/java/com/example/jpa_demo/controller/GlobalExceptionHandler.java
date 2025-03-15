package com.example.jpa_demo.controller;

import com.example.jpa_demo.dto.AppErrorResponse;
import com.example.jpa_demo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = {MethodArgumentNotValidException.class})
    public ResponseEntity<AppErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        String message = "";
        for (ObjectError error: allErrors){
            message = error.getDefaultMessage();
        }

        AppErrorResponse errorResponse = new AppErrorResponse();
        errorResponse.setCode("Bad Request");
        errorResponse.setMessage(message);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(exception = {ResourceNotFoundException.class})
    public ResponseEntity<AppErrorResponse> handleRuntimeException(ResourceNotFoundException exception){

        AppErrorResponse errorResponse = new AppErrorResponse();
        errorResponse.setCode("RESOURCE NOT FOUND");
        errorResponse.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
