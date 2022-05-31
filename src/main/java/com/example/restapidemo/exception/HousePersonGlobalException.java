package com.example.restapidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HousePersonGlobalException {
    @ExceptionHandler
    public ResponseEntity<HousePersonErrorResponse> handleException(HousePersonNotFoundException hou){
        HousePersonErrorResponse error = new HousePersonErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(hou.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<HousePersonErrorResponse> handleException(Exception exc){
        HousePersonErrorResponse error = new HousePersonErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
