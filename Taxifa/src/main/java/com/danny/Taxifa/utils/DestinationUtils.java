package com.danny.taxifa.utils;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class DestinationUtils {



    public static LocalTime departureTime(){
        return LocalTime.now();

    }

    public static LocalTime arrivalTime(){
      return   departureTime().plusHours(8);

    }






}
