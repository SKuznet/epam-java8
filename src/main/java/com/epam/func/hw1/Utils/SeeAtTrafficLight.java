package com.epam.func.hw1.Utils;

import com.epam.func.hw1.ColorOfTrafficLight;

public class SeeAtTrafficLight {

    /**
     * This method check user input (correct userMinute) and return String result.
     * If input incorrect, than returns null.
     * @param userMinute - it's minute, when some color is.
     * @param trafficLight - functional interface with findColorByMinute method
     * @return null if input is incorrect, or String "green" or "red" or "yellow".
     */
    public String color(Number userMinute, TrafficLight trafficLight){
        if (correctMinute(userMinute)){
            return trafficLight.findColorByMinute((Integer)userMinute).toString();
        } else {
            return null;
        }
    }

    /**
     * This method describes logic of lights switch in our case
     * @param i minutes of work of lights (traffic lights). Must be correct!
     * @return one of the color.
     */
    public ColorOfTrafficLight theLights(int i){
        final int div = i % 6;
        if (div == 0 || div == 1) {
            return ColorOfTrafficLight.RED;
        } else if (div == 2) {
            return ColorOfTrafficLight.YELLOW;
        } else
            return ColorOfTrafficLight.GREEN;
    }

    /**
     * Check if user input is correct
     * @param userMinute - from zero to MAX_INT
     * @return true if userMinute is correct
     */
    private boolean correctMinute(Number userMinute) {
        try {
            Integer minute = (Integer) userMinute;
            return minute >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
