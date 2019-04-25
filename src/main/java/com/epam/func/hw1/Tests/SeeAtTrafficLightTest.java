package com.epam.func.hw1.Tests;

import com.epam.func.hw1.ColorOfTrafficLight;
import com.epam.func.hw1.Utils.SeeAtTrafficLight;
import com.epam.func.hw1.Utils.TrafficLight;

import static org.junit.jupiter.api.Assertions.*;

class SeeAtTrafficLightTest {

    @org.junit.jupiter.api.Test
    void color() {
        SeeAtTrafficLight test = new SeeAtTrafficLight();
        TrafficLight light = i -> {
            final int div = i % 6;
            if (div == 0 || div == 1) {
                return ColorOfTrafficLight.RED;
            } else if (div == 2) {
                return ColorOfTrafficLight.YELLOW;
            } else
                return ColorOfTrafficLight.GREEN;
        };
        assertNull(test.color(Integer.MAX_VALUE + 1, light));
        assertNull(test.color(-3, light));

        assertEquals(test.color(1, light), "red");
        assertEquals(test.color(3, light), "yellow");
        assertEquals(test.color(6, light), "green");
    }

    @org.junit.jupiter.api.Test
    void theLights(){
        SeeAtTrafficLight test = new SeeAtTrafficLight();
        assertNull(test.color(Integer.MAX_VALUE + 1, test::theLights));
        assertNull(test.color(-3, test::theLights));

        assertEquals(test.color(1, test::theLights), "red");
        assertEquals(test.color(3, test::theLights), "yellow");
        assertEquals(test.color(6, test::theLights), "green");
    }
}