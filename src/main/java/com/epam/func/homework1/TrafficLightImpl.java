package com.epam.func.homework1;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.epam.func.homework1.Light.*;

public class TrafficLightImpl implements TrafficLight {

    private Light currentLight;
    private Light nextLight;

    @Override
    public Light getCurrentLight() {
        return currentLight;
    }

    @Override
    public void changeLight() {
        switch (currentLight) {
            case RED: {
                currentLight = YELLOW;
                nextLight = GREEN;
                break;
            }
            case YELLOW: {
                currentLight = nextLight;
                break;
            }
            case GREEN: {
                currentLight = YELLOW;
                nextLight = RED;
                break;
            }
        }
    }

    @Override
    public Light checkLight(int time) {
        currentLight = RED;
        nextLight = GREEN;
        BiPredicate<Light, Integer> checkRed = (light, t) -> (t == 2 && light.equals(RED));
        BiPredicate<Light, Integer> checkGreen = (light, t) -> (t == 3 && light.equals(GREEN));
        Predicate<Light> checkYellow = light -> light.equals(YELLOW);
        int count = 0;
        for (int i = 0; i < time; i++) {
            count++;
            if (checkGreen.test(currentLight, count) || checkRed.test(currentLight, count) || checkYellow.test(currentLight)) {
                count = 0;
                changeLight();
            }
        }
        return getCurrentLight();
    }
}
