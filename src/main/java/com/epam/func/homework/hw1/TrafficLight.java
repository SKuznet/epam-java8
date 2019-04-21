package com.epam.func.homework.hw1;

import java.io.BufferedReader;
import java.util.Optional;
import java.util.concurrent.Callable;

public class TrafficLight implements Callable<Light> {
    private static final int CYCLE_TIME = 6;
    private BufferedReader reader;

    public TrafficLight(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public Light call() throws Exception {
        return defineLight();
    }

    private Light defineLight() throws Exception {
        System.err.println("Enter a minute:");
        while (true) {
            final String userInput = reader.readLine();
            try {
                Double minute = Optional.of(Double.parseDouble(userInput))
                        .filter(number ->
                                number > 0 && number <= Double.MAX_VALUE)
                        .orElseThrow(NumberFormatException::new);
                return computeLight(minute);
            } catch (NumberFormatException e) {
                System.err.println("Please, enter a positive number.");
            }
        }
    }

    private Light computeLight(double time) {
        while (time > CYCLE_TIME) {
            time %= CYCLE_TIME;
        }
        return Optional.ofNullable(
                    time > 0 && time <= 2 ? Light.RED :
                    time > 2 && time <= 3 ? Light.YELLOW :
                    (time > 3 && time <= 6) || time == 0 ? Light.GREEN : null)
                .orElseThrow(RuntimeException::new);
    }
}
