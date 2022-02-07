package com.danny.taxifa.exceptions;

import com.danny.taxifa.enums.Destination;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class DestinationException extends RuntimeException {




    @Enumerated(EnumType.STRING)
    private final Destination destination;

    public DestinationException(Destination destination) {
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }
}
