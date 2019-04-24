package com.epam.func.hw1;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(TrafficLight::new);

        System.console();
    }

}
