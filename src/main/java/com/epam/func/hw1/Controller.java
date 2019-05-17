package com.epam.func.hw1;

import com.epam.func.hw1.util.Light;

import java.io.IOException;

public class Controller {

    private Reader reader;
    private TrafficLighterService trafficLighterService;
    private Writer writer;

    Controller(Reader reader, TrafficLighterService trafficLighterService, Writer writer) {
        this.reader = reader;
        this.trafficLighterService = trafficLighterService;
        this.writer = writer;
    }

    public void mainFlow() {
        while (true) {
            String line = reader.readLine();

            if (line.toLowerCase().equals("finish")) {
                System.exit(1);
            }

            try {
                Double num = stringToDouble(line);
                Light currentLight = trafficLighterService.getCurrentLight(num);
                writer.writeAnsToConsole(currentLight);
            } catch (IOException e) {
                writer.writeMsgToConsole(e.getMessage());
            }
        }
    }

    private Double stringToDouble(String string) throws IOException {
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            throw new IOException("If you want to quit program type 'finish', otherwise type number");
        }
    }
}
