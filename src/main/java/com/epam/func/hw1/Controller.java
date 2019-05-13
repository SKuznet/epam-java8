package com.epam.func.hw1;

import java.util.Scanner;

public class Controller {

    private Reader reader;
    private TrafficLighterService trafficLighterService;

    Controller(Reader reader, TrafficLighterService trafficLighterService) {
        this.reader = reader;
        this.trafficLighterService = trafficLighterService;
    }

    public void read() {
        while (true) {
            String line = reader.readLine();
            try {
                Double num = Double.parseDouble(line);
                trafficLighterService.getColor(num);
            } catch (NumberFormatException e) {
                if (line.toLowerCase().equals("finish")) {
                    System.exit(1);
                } else {
                    System.out.println("To exit program type 'finish', to get proper answer type any number");
                }
            }
        }
    }
}
