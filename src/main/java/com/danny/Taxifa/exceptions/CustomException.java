package com.danny.taxifa.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomException extends RuntimeException {




    private static  final long serialVersionUID = 1L;
    private final String message;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CustomException (String message, Class<?> clazz){

        this.message = message;
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message);




    }



}
