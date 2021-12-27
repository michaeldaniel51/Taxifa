package com.danny.Taxifa.enums;

public enum TripType {



    LONG("sit back and relax it's going to be a long trip"),
    SHORT("this is a short trip : relax it wont take long");

    TripType(String message) {
        this.message = message;
    }

    private String message;
}
