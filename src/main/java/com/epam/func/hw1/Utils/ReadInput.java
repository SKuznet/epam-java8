package com.epam.func.hw1.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class ReadInput {
    public void readFromConsole() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            SeeAtTrafficLight logic = new SeeAtTrafficLight();
            while (true) {
                try {
                    Integer input = new Integer(br.readLine());
                    String color = logic.color(input, logic::theLights);
                    if (color != null) {
                        System.out.println(color);
                    } else {
                        System.err.println("Not in the interval!");
                    }
                } catch (IOException | InputMismatchException | NumberFormatException e) {
                    System.err.println("please, use numbers as in prescription");
                }
            }
        } catch (IOException e) {
            System.err.println("Exception from reader!");
            e.printStackTrace();
        }
    }
}
