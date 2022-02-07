package com.danny.taxifa.utils;

import java.util.Random;
import java.util.UUID;

public class TrackingIdUtils {


    public static String trackingNo (){
        String g = "000";
        Random f = new Random();
       int b = f.nextInt(5000);
        return g + b;
    }




}
