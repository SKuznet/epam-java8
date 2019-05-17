package com.epam.func.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class TrafficLight implements Callable<Light> {

    private static final int MINUTES_IN_CYCLE = 6;
    private final BufferedReader reader;

    public TrafficLight(BufferedReader reader) {
        this.reader = reader;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Please, enter a minute: ");
                TrafficLight trafficLight = new TrafficLight(reader);
                Light currentLight = executorService.submit(trafficLight).get();
                if (currentLight != null) {
                    System.err.println(currentLight);
                }
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    @Override
    public Light call() {
        return getCurrentLight();
    }

    private Light getCurrentLight() {
        int minute;
        try {
            minute = readMinute();
            checkInputValue(minute);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }

        if (minute > MINUTES_IN_CYCLE) {
            minute %= MINUTES_IN_CYCLE;
        }

        if (minute >= 0 && minute <= 2) {
            return Light.RED;
        } else if (minute == 3) {
            return Light.YELLOW;
        } else {
            return Light.GREEN;
        }
    }

    private int readMinute() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException("Please, enter correct integer!");
        }
    }

    private void checkInputValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Please, enter correct integer!");
        }
    }
}
