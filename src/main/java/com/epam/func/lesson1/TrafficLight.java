package com.epam.func.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

class TrafficLight implements Runnable{

    private static final int RED_LIGHT_DURATION = 2;
    private static final int YELLOW_LIGHT_DURATION = 1;
    private static final int GREEN_LIGHT_DURATION = 3;

    private final Optional<Double> requestedTime;

    TrafficLight(Optional<Double> requestedTime) {
        this.requestedTime = requestedTime;
    }

    @Override
    public void run() {
        System.out.println("Wait a second...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestedTime.ifPresent(this::computeAndPrintColor);
    }

    private void computeAndPrintColor(Double aDouble) {
        Double normalizeDouble = normalizeValue(aDouble);

        if (isRed(normalizeDouble)) {
            System.out.println("RED");
        } else if (isYellow(normalizeDouble)) {
            System.out.println("YELLOW");
        } else {
            System.out.println("GREEN");
        }
    }

    private Double normalizeValue(Double aDouble) {
        return aDouble % totalTrafficLightDuration();
    }

    private int totalTrafficLightDuration() {
        final Light redLight = new Light(RED_LIGHT_DURATION);
        final Light yellowLight = new Light(YELLOW_LIGHT_DURATION);
        final Light greenLight = new Light(GREEN_LIGHT_DURATION);

        final List<Light> lights = new ArrayList<>();
        lights.add(redLight);
        lights.add(yellowLight);
        lights.add(greenLight);

        return lights.stream().mapToInt(Light::getDuration).sum();
    }

    private boolean isRed(Double aDouble) {
        return isInTheInterval(
                0,
                new Light(RED_LIGHT_DURATION).getDuration(),
                aDouble);
    }

    private boolean isYellow(Double aDouble) {
        return isInTheInterval(
                new Light(RED_LIGHT_DURATION).getDuration(),
                new Light(YELLOW_LIGHT_DURATION).getDuration(),
                aDouble);
    }

    private boolean isGreen(Double aDouble) {
        return isInTheInterval(
                new Light(RED_LIGHT_DURATION).getDuration() + new Light(YELLOW_LIGHT_DURATION).getDuration(),
                new Light(GREEN_LIGHT_DURATION).getDuration(),
                aDouble);
    }


    private boolean isInTheInterval(int start, int duration, Double aDouble) {
        return start <= aDouble && aDouble < start + duration;
    }
}