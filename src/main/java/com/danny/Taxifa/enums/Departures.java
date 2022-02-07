package com.danny.taxifa.enums;


public enum Departures {

    MORNING("12:00am - 11:59am"),
    AFTERNOON("12:00pm - 3:59pm"),
    EVENING("4:00pm - 5:59pm"),
    NIGHT("6:00pm - 11:59pm");

    private String message;

    Departures(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
