package com.epam.func.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

class TrafficLight {
    void printColor(Optional<Double> optionalDouble) {
        System.out.println("Wait a second...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        optionalDouble.ifPresent(this::computeAndPrintColor);
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
        final RedLight redLight = new RedLight();
        final YellowLight yellowLight = new YellowLight();
        final GreenLight greenLight = new GreenLight();

        final List<Light> lights = new ArrayList<>();
        lights.add(redLight);
        lights.add(yellowLight);
        lights.add(greenLight);

        return lights.stream().mapToInt(Light::getDuration).sum();
    }

    private boolean isRed(Double aDouble) {
        return inTheInterval(
                0,
                new RedLight().getDuration(),
                aDouble);
    }

    private boolean isYellow(Double aDouble) {
        return inTheInterval(
                new RedLight().getDuration(),
                new YellowLight().getDuration(),
                aDouble);
    }

    private boolean isGreen(Double aDouble) {
        return inTheInterval(
                new RedLight().getDuration() + new YellowLight().getDuration(),
                new GreenLight().getDuration(),
                aDouble);
    }


    private boolean inTheInterval(int start, int duration, Double aDouble) {
        return start <= aDouble && aDouble < start + duration;
    }

    class RedLight implements Light {
        @Override
        public int getDuration() {
            return 2;
        }
    }

    class YellowLight implements Light {
        @Override
        public int getDuration() {
            return 1;
        }
    }


    class GreenLight implements Light {
        @Override
        public int getDuration() {
            return 3;
        }
    }
}

interface Light {
    int getDuration();
}