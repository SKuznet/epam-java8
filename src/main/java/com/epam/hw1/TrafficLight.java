package com.epam.hw1;

import com.epam.hw1.exception.TrafficLightException;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TrafficLight implements Runnable {
    private Semaphore previous;
    private Semaphore next;
    private Light light;
    private int minutes;

    public TrafficLight(Semaphore previous, Semaphore next, Light light, int minutes) {
        this.previous = previous;
        this.next = next;
        this.light = light;
        this.minutes = minutes;
    }

    @Override
    public void run() {
        while (true) {
            try {
                waitForOpening();
                System.out.println("Now " + light + " light is on");
                TimeUnit.MINUTES.sleep(minutes);
                openSemaphoreForNext();
            } catch (InterruptedException e) {
                throw new TrafficLightException(e);
            }
        }
    }

    private void openSemaphoreForNext() {
        next.release();
    }

    private void waitForOpening() throws InterruptedException {
        previous.acquire();
    }
}
