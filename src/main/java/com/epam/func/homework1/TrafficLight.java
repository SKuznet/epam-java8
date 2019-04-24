package com.epam.func.homework1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;


public class TrafficLight {
    private Light green;
    private Light yellow;
    private Light red;
    private Map<Light, Predicate<Integer>> lightPredicateMap;

    public TrafficLight() {
        this.green = new Light("green");
        this.yellow = new Light("yellow");
        this.red = new Light("red");
        this.lightPredicateMap = initialize();
    }

    private Map<Light, Predicate<Integer>> initialize() {
        Map<Light, Predicate<Integer>> map = new HashMap<>();
        map.put(green, x -> x > 0);
        map.put(yellow, x -> x == 0);
        map.put(red, x -> x < 0);
        return map;
    }

    public String getLight(int minute) {
        final Integer t = Integer.compare((minute-1) % 6 - 2, 0);
        Function<Light, String> function = Light::getLight;
        AtomicReference<String> color = new AtomicReference<>();
        lightPredicateMap.forEach((light, predicate) -> {
            if (predicate.test(t))
                color.set(function.apply(light));
        });
        return String.valueOf(color);
    }


}
