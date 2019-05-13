package com.epam.func.lesson5.hw;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WhenCompleteExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture
                .supplyAsync(() -> 4 / 2)
                .whenComplete((result, e) -> {
                    if (e != null) {
                        System.out.println("An exception has occurred: " + e);
                    } else {
                        System.out.println("The result is: " + result);
                    }
                });

        CompletableFuture
                .supplyAsync(() -> 4 / 0)
                .whenComplete((result, e) -> {
                    if (e != null) {
                        System.out.println("An exception has occurred: " + e);
                    } else {
                        System.out.println("The result is: " + result);
                    }
                })
    }
}

