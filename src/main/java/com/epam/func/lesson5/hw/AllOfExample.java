package com.epam.func.lesson5.hw;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOfExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });

        CompletableFuture<Void> allOf = CompletableFuture.allOf(cf1, cf2);
        allOf.get();
        if (allOf.isDone()) {
            System.out.println("All futures completed. Results: cf1 - " + cf1.get() + ", cf2 - " + cf2.get());
        } else {
            System.out.println("One of the futures was not ready.");
        }
    }
}

