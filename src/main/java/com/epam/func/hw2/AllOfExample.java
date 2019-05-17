package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AllOfExample {
    private static final int SLEEP_TIME = 3;

    private static final CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I've been sleeping for " + SLEEP_TIME + " seconds";
    });

    private static final CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "I've been awake all this time");

    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.allOf(future1, future2);
        try {
            System.out.println("Future: " + future.isDone());
            System.out.println("Future1: " + future1.isDone());
            System.out.println("Future2: " + future2.isDone());

            System.out.println("\nWaiting...\n");
            future.get();

            System.out.println("Future: " + future.isDone());
            System.out.println("Future1: " + future1.isDone() + ", " + future1.get());
            System.out.println("Future2: " + future2.isDone() + ", " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
