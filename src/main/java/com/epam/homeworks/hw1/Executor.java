package com.epam.homeworks.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Executor {
    private final BufferedReader reader;

    public Executor() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Check if value can be converted to Integer or not
     *
     * @return true - if can, false if not
     */
    private boolean checkOnNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Method get a number from console
     *
     * @return something that user send through console
     */
    public int getMinute() {
        String minute = null;
        try {
            minute = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (checkOnNumber(minute)) {
            return Integer.parseInt(minute);
        } else {
            throw new IllegalArgumentException("There is a wrong number here");
        }
    }

    /**
     * Method calculate an answer on question:
     * Which color is currently ON
     */
    public String answer(int minute) {
        int rest = minute % 6;
        String currentColor;

        switch (rest) {
            case 0:
            case 1:
                currentColor = Color.RED.toString();
                break;
            case 2:
                currentColor = Color.YELLOW.toString();
                break;
            default:
                currentColor = Color.GREEN.toString();
        }
        return currentColor;
    }
}
