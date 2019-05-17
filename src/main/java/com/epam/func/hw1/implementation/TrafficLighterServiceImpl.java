package com.epam.func.hw1.implementation;

import com.epam.func.hw1.TrafficLighterService;
import com.epam.func.hw1.util.Light;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrafficLighterServiceImpl implements TrafficLighterService {

    private final List<Light> orderedLightList;
    private Integer cycleDuration;

    private TrafficLighterServiceImpl() {
        this.orderedLightList = new ArrayList<>();

        orderedLightList.add(Light.RED_LIGHT);
        orderedLightList.add(Light.YELLOW_LIGHT);
        orderedLightList.add(Light.GREEN_LIGHT);

        cycleDuration = calculateCycleDuration();
    }

    public Light getCurrentLight(Double num) throws IOException {
        Double currCycleTime = num % cycleDuration;
        for (Light light : orderedLightList) {
            currCycleTime -= light.getDuration();

            if (currCycleTime <= 0) {
                return light;
            }
        }
        throw new IOException("Something definitely goes wrong");
    }

    private Integer calculateCycleDuration() {
        Integer sum = 0;
        for (Light light : orderedLightList) {
            sum += light.getDuration();
        }
        return sum;
    }

    private static class TrafficServiceHolder {
        private static final TrafficLighterServiceImpl TRAFFIC_SERVICE_INSTANCE = new TrafficLighterServiceImpl();
    }

    public static TrafficLighterServiceImpl getInstance() {
        return TrafficServiceHolder.TRAFFIC_SERVICE_INSTANCE;
    }
}

