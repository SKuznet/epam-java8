package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;

public class whenCompleteExample {
    public static void main(String[] args) throws Exception {
        runTasks(2);
        runTasks(0);
    }

    private static void runTasks(int i) {
        System.out.printf("Input: %s\n", i);

        CompletableFuture.supplyAsync(() -> 16 / i)
                .whenComplete((input, exception) -> {
                    if (exception != null) {
                        System.out.print("An exception occurred: ");
                        System.err.println(exception);
                    } else {
                        System.out.println("No exceptions\n16 / " + i + " = " + input);
                    }
                })
                .thenApply(input -> input * 3)
                .thenAccept(x -> {
                    System.out.println("input * 3 = " + x + "\n");
                });
    }
}
