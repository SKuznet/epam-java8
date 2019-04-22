package com.epam.func.homework1;

import static com.epam.func.homework1.Light.*;


public class TrafficLight {
    private Light currentLight;
    private Light nextLight;
    private int duration;

    public TrafficLight() {
        duration = 0;
        currentLight = RED;
        nextLight = GREEN;
    }

    public Light getCurrentLight() {
        return currentLight;
    }

    public int getDuration() {
        return duration;
    }

    public void changeLight() {
        switch (currentLight) {
            case RED: {
                duration += 2;
                currentLight = YELLOW;
                nextLight = GREEN;
                break;
            }
            case YELLOW: {
                duration++;
                currentLight = nextLight;
                break;
            }
            case GREEN: {
                duration += 3;
                currentLight = YELLOW;
                nextLight = RED;
                break;
            }
        }
    }

    public Light checkLight(int time) {
        duration = 0;
        while (duration < time) {
            changeLight();
        }
        return getCurrentLight();
    }
}
