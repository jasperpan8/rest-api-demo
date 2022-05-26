package com.example.restapidemo.exception;

public class HouseNotFoundException extends RuntimeException{

    public HouseNotFoundException(String message) {
        super(message);
    }

    public HouseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HouseNotFoundException(Throwable cause) {
        super(cause);
    }
}
