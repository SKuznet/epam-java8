package com.epam.func.hw1;

public interface SignalLight {
        int LOOP_DURATION = 60;
        int RED_DURATION = 2;
        int YELLOW_DURATION = 1;
        int GREEN_DURATION = 3;
        int TOTAL_DURATION = RED_DURATION + YELLOW_DURATION + GREEN_DURATION;

        enum SignalLightColors {RED, YELLOW, GREEN}

        SignalLightColors checkColor(int minutes);
}
