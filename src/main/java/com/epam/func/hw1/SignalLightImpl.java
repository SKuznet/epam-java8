package com.epam.func.hw1;

import java.util.function.BiPredicate;

public class SignalLightImpl implements SignalLight{
    @Override
    public SignalLightColors checkColor(int minutes) {
        BiPredicate<Integer, Integer> checkDuration = (a, b) -> minutes % (a) < b;

        if (checkDuration.test(TOTAL_DURATION, RED_DURATION)) {
            return SignalLightColors.RED;
        }
        else if (checkDuration.test(TOTAL_DURATION,RED_DURATION + YELLOW_DURATION)) {
            return SignalLightColors.YELLOW;
        }
        return SignalLightColors.GREEN;
    }
}
