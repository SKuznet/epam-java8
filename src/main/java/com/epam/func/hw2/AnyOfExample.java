package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AnyOfExample {
    private static final int MAX_SLEEP_TIME = 1000;

    private static final CompletableFuture<String> future1 = CompletableFuture.supplyAsync(
            () -> "I'm the 1st one and I've been sleeping for " + sleep() + " ms"
    );
    private static final CompletableFuture<String> future2 = CompletableFuture.supplyAsync(
            () -> "I'm the 2nd one and I've been sleeping for " + sleep() + " ms"
    );
    private static final CompletableFuture<String> future3 = CompletableFuture.supplyAsync(
            () -> "I'm the 3rd one and I've been sleeping for " + sleep() + " ms"
    );

    private static long sleep() {
        long sleepTime = (long) (Math.random() * MAX_SLEEP_TIME);
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sleepTime;
    }

    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.anyOf(future1, future2, future3);
        try {
            System.out.println("Future: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
