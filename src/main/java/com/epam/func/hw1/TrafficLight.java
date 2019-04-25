package com.epam.func.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface TrafficLight {

    default String countLight(Double minute) {
        if (minute % 6 == 0) {
            return "Green light";
        } else if (minute % 6 < 2) {
            return "Red light";
        } else if (minute % 6 < 3) {
            return "Yellow light";
        }
        return "Green light";
    }


    String readLine();


}
