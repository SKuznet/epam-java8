package com.epam.func.hw1;

import java.util.function.Consumer;

public class TrafficLight {
    private Consumer<Integer> colorOfTrafficLight;
    private static final int TRAFFICLIGHTCYCLE = 6;

    public TrafficLight(Consumer<Integer> colorOfTrafficLight) {
        this.colorOfTrafficLight = colorOfTrafficLight;
    }

    public static void checkLightColor(int minute) {
        int period = minute % TRAFFICLIGHTCYCLE;
        switch (period) {
            case 1:
            case 2:
                System.out.println(Light.RED);
                break;
            case 3:
                System.out.println(Light.YELLOW);
                break;
            case 4:
            case 5:
            case 0:
                System.out.println(Light.GREEN);
                break;
        }
    }

    public void printColor(int minute) {
        colorOfTrafficLight.accept(minute);
    }
}
