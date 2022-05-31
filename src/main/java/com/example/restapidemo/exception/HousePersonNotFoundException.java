package com.example.restapidemo.exception;

public class HousePersonNotFoundException extends RuntimeException{
    public HousePersonNotFoundException(String message) {
        super(message);
    }

    public HousePersonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HousePersonNotFoundException(Throwable cause) {
        super(cause);
    }
}
