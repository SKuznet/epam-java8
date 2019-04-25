package com.epam.func.hw1;

public interface TrafficLight {
    int LOOP_DURATION = 60;
    int RED_DURATION = 2;
    int YELLOW_DURATION = 1;
    int GREEN_DURATION = 3;
    int TOTAL_DURATION = RED_DURATION + YELLOW_DURATION + GREEN_DURATION;

    enum TrafficLightColors {RED, YELLOW, GREEN}

    TrafficLightColors checkColor(int minutes);
}
