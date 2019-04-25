package com.epam.func.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.function.Supplier;

public class TrafficLightImp implements TrafficLight {


    public static void main(String[] args) {

        TrafficLightImp light = new TrafficLightImp();
        Function<String, Double> toDouble = Double::valueOf;

        while (true) {
            System.out.println("Enter a minute, enter 0 for exit");

            try {

                Double minute = toDouble.apply(light.readLine());
                if (minute < 0) {
                    System.out.println("ERROR!\nValue must be positive");
                } else if (minute == 0) {
                    System.out.println("Goodbye");
                    System.exit(0);
                } else {
                    System.out.println(light.countLight(minute));
                }


            } catch (NumberFormatException e) {
                System.out.println("ERROR!\ninput value must be real");

            }


        }
    }

    @Override
    public String readLine() {
        String inputString = null;

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            inputString = bufferRead.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return inputString;
    }
}
