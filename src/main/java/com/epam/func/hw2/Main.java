package com.epam.func.hw2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFutureExample example = new CompletableFutureExample(executorService);

        try {
            example.anyOfExample();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        example.allOfAndWhenCompleteExample();

        executorService.shutdownNow();
    }
}
