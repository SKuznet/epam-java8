package com.epam.func.hw1;

import java.util.ArrayList;
import java.util.List;

public class TrafficLighterService {

    private final List<Light> orderedLightList;

    TrafficLighterService() {
        this.orderedLightList = new ArrayList<>();
        orderedLightList.add(Light.RED_LIGHT);
        orderedLightList.add(Light.YELLOW_LIGHT);
        orderedLightList.add(Light.GREEN_LIGHT);
    }

    public Light getColor(Double num) {
        return Light.GREEN_LIGHT;
    }

}
