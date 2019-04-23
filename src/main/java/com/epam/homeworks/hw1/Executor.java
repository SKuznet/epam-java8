package com.epam.homeworks.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Executor {
    private final BufferedReader reader;
    TriFunction<String, Integer, Integer, Color>  newColor = Color::new;

    private Color red;
    private Color yellow;
    private Color green;

    public Executor() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        red = newColor.create("red", 0, 2);
        yellow = newColor.create("yellow", 2, 3);
        green = newColor.create("red", 3, 5);

    }

    private boolean checkOnNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getNumber() {
        String number = null;
        try {
            number = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (checkOnNumber(number)) {
            return Integer.parseInt(number);
        } else {
            throw new IllegalArgumentException("There is a wrong number here");
        }
    }

    public String answer (int number){
        throw new UnsupportedOperationException();
    }
}
