package com.epam.func.hw1;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight implements Runnable{

    private List<Light> lights;

    public TrafficLight() {
        this.lights = new ArrayList<Light>() {{
            add(new Light(Color.RED, 2));
            add(new Light(Color.YELLOW, 1));
            add(new Light(Color.GREEN, 3));
        }};
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            lights.forEach(light -> {
                if(true){

                }
            });
        }
    }
}
