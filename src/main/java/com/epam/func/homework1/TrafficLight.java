package com.epam.func.homework1;

/**
 * Created by vladd on 25.04.2019
 */

import java.util.function.Consumer;

public class TrafficLight {
    private Consumer<Integer> colorOfTrafficLight;
    private static final int TRAFFIC_LIGHT_CYCLE = 6;

    public TrafficLight(Consumer<Integer> colorOfTrafficLight) {
        this.colorOfTrafficLight = colorOfTrafficLight;
    }

    public static void checkLightColor(int minute) {

        switch (minute % TRAFFIC_LIGHT_CYCLE) {
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
