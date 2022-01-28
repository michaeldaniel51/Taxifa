package com.danny.Taxifa.exceptions;

import com.danny.Taxifa.enums.Destination;

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
