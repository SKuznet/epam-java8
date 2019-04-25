package com.epam.func.hw1;

import java.util.function.BiPredicate;

public class TrafficLightImpl implements TrafficLight {
    @Override
    public TrafficLightColors checkColor(int minutes) {
        BiPredicate<Integer, Integer> checkDuration = (a, b) -> minutes % (a) < b;

        if (checkDuration.test(TOTAL_DURATION, RED_DURATION)) {
                return TrafficLightColors.RED;
            }
            else if (checkDuration.test(TOTAL_DURATION,RED_DURATION + YELLOW_DURATION)) {
                return TrafficLightColors.YELLOW;
            }
            return TrafficLightColors.GREEN;
    }
}
