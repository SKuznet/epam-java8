package com.epam.hw1;

import com.epam.hw1.exception.WrongInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.concurrent.Semaphore;

public class App {
    private boolean isRunning = true;

    public void initMainLoop() throws IOException, InterruptedException {
        System.out.println("Enter the minute to see which light is on or simply type \"run\" to see the traffic light works");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (isRunning) {
            String input = br.readLine();
            processInput(input);
        }
    }

    private void processInput(String input) throws InterruptedException {
        if (input.equals("run")) {
            runTrafficLight();
            isRunning = false;
            return;
        }
        try {
            double minutes = Double.parseDouble(input);
            if (minutes < 0) throw new WrongInputException("Number should be greater than zero");
            System.out.println("The light is " + calculateLight(minutes).get());
        } catch (NumberFormatException e) {
            throw new WrongInputException("You must input a number", e);
        }
    }

    public Optional<Light> calculateLight(double minute) {
        double minuteInCycle = minute % 6;
        if (minuteInCycle >= 0 && minuteInCycle < 2) return Optional.of(Light.RED);
        else if (minuteInCycle >= 2 && minuteInCycle < 3) return Optional.of(Light.YELLOW);
        else return Optional.of(Light.GREEN);
    }

    public void runTrafficLight() throws InterruptedException {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);
        semaphore1.acquire();
        semaphore2.acquire();
        semaphore3.acquire();

        Thread t1 = new Thread(new TrafficLight(semaphore3, semaphore1, Light.RED, 2));
        Thread t2 = new Thread(new TrafficLight(semaphore1, semaphore2, Light.YELLOW, 1));
        Thread t3 = new Thread(new TrafficLight(semaphore2, semaphore3, Light.GREEN, 3));

        t1.start();
        t2.start();
        t3.start();
        semaphore3.release();
    }
}
