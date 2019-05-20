package com.epam.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExampleApp {
    public static void main(String[] args) {
        anyOfExample();
        allOfExample();
        whenCompleteExample();
    }

    public static void anyOfExample() {
        System.out.println("--------------------------");
        CompletableFuture<String> countTask1 = getCountTask1();
        CompletableFuture<String> countTask2 = getCountTask2();

        CompletableFuture completableFuture = CompletableFuture.anyOf(countTask1, countTask2);
        String result;
        try {
            result = (String) completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("An error occurred while getting the result");
        }
        System.out.println(result);
    }

    public static void allOfExample() {
        System.out.println("--------------------------");
        CompletableFuture<String> countTask1 = getCountTask1();
        CompletableFuture<String> countTask2 = getCountTask2();
        CompletableFuture completableFuture = CompletableFuture.allOf(countTask1, countTask2);
        System.out.println("is tasks done: " + completableFuture.isDone());
        System.out.println("waiting for a while...");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException("An error occurred while getting the result");
        }
        System.out.println("is tasks done: " + completableFuture.isDone());
    }

    public static void whenCompleteExample() {
        System.out.println("--------------------------");
        CompletableFuture<String> countTask1 = getCountTask1();
        countTask1.whenComplete((x, throwable) -> System.out.println(x + " and it's completed"));
        try {
            countTask1.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("An error occurred while getting the result");
        }
    }

    private static CompletableFuture<String> getCountTask1() {
        return CompletableFuture.supplyAsync(() -> {
            long time1 = System.currentTimeMillis();
            long someSum = 0;
            for (int i = 0; i < 100_000_000; i++) {
                someSum += i;
            }
            long time2 = System.currentTimeMillis();
            return "first task has finished its work with " + (time2 - time1) + " ms";
        });
    }

    private static CompletableFuture<String> getCountTask2() {
        return CompletableFuture.supplyAsync(() -> {
            long time1 = System.currentTimeMillis();
            long someSum = 0;
            for (int i = 0; i < 100_000_000; i++) {
                someSum += i;
            }
            long time2 = System.currentTimeMillis();
            return "second task has finished its work with " + (time2 - time1) + " ms";
        });
    }
}
