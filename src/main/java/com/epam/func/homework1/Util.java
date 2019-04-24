package com.epam.func.homework1;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;

public class Util {

    static TrafficLight trafficLight = new TrafficLightImpl();

    private Util() {
    }

    public static boolean checkExit(String str) {
        Predicate<String> checkExit = string -> string.equalsIgnoreCase("y");
        return checkExit.test(str);
    }

    public static void print(String string, Integer value) {
        ObjIntConsumer<String> out = (str, type) -> {
            if (type == 1) {
                System.out.println(str);
            } else if (type == 2) {
                System.err.println(str);
            }
        };
        out.accept(string, value);
    }

    public static void getLight(int time) {
        IntConsumer getLight = t -> {
            IntFunction<Light> checkLight = trafficLight::getLight;
            print(checkLight.apply(t).toString(), 1);
        };
        getLight.accept(time);
    }

}
