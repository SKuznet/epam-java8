package com.epam.func.hw1.Utils;

import com.epam.func.hw1.ColorOfTrafficLight;

@FunctionalInterface
public interface TrafficLight {

    /**
     * this method can count what light is
     * @param minute - any minute in TrafficLight lifecycle
     * @return - color of TrafficLight
     */
    ColorOfTrafficLight findColorByMinute(Integer minute);
}
