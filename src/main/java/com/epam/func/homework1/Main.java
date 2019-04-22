package com.epam.func.homework1;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        System.out.println(trafficLight.checkLight(10));
        System.out.println(trafficLight.checkLight(25));
        System.out.println(trafficLight.checkLight(31));
        System.out.println(trafficLight.checkLight(43));
        System.out.println(trafficLight.checkLight(58));
    }
}
