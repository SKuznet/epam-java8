package com.epam.func.hw1;

import java.util.Arrays;

import static com.epam.func.hw1.TrafficLight.TrafficLightState.*;


public class TrafficLight {

    public static TrafficLightState getColorAfterTime(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cant be negative.");
        }
        int modMinutes = minutes % TrafficLightState.getFullCycleTime();
        TrafficLightState result;

        if (modMinutes < RED.getTime()) {
            result = RED;
        } else if (modMinutes < RED.getTime() +
                YELLOW.getTime()) {
            result = YELLOW;
        } else if (modMinutes < RED.getTime() + YELLOW.getTime() + GREEN.getTime()) {
            result = GREEN;
        } else {
            throw new IllegalArgumentException("Wrong argument value");
        }
        return result;
    }

    public enum TrafficLightState {
        RED(2),
        YELLOW(1),
        GREEN(3);

        private final int time;

        TrafficLightState(int time) {
            this.time = time;
        }

        static int getFullCycleTime() {
            return Arrays.stream(TrafficLightState.values())
                    .mapToInt(TrafficLightState::getTime)
                    .sum();
        }

        public int getTime() {
            return time;
        }
    }
}
