package com.danny.Taxifa.exceptions;

import lombok.Getter;

@Getter
public class DriverNotFoundException extends RuntimeException{


    private String message;


    public DriverNotFoundException(String message) {
        this.message = message;
    }
}
