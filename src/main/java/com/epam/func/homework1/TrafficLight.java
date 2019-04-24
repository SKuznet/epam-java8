package com.epam.func.homework1;

public interface TrafficLight {
    Light getCurrentLight();

    void changeLight();

    Light checkLight(int time);
}
