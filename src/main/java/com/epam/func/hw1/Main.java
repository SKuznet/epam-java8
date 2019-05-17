package com.epam.func.hw1;

import com.epam.func.hw1.implementation.ReaderImpl;
import com.epam.func.hw1.implementation.TrafficLighterServiceImpl;
import com.epam.func.hw1.implementation.WriterImpl;

public class Main {
    public static void main(String[] args) {
        Reader reader = ReaderImpl.getInstance();
        Writer writer = WriterImpl.getInstance();
        TrafficLighterService trafficLighterService = TrafficLighterServiceImpl.getInstance();

        Controller controller = new Controller(reader, trafficLighterService, writer);
        controller.mainFlow();
    }
}
