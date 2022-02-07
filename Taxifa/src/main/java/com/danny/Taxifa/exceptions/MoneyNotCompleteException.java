package com.danny.taxifa.exceptions;

import lombok.Getter;

@Getter
public class MoneyNotCompleteException extends RuntimeException {

    private String message;

    public MoneyNotCompleteException(String message) {
        this.message = message;
    }
}
