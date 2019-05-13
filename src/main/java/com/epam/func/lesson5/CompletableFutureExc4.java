package com.epam.func.lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExc4 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hi";
        });

        future.thenAccept(System.out::println);

        final CompletableFuture<String> future1 = future.thenApplyAsync(string -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return string.toUpperCase();
        });
        future1.thenAccept(System.out::println);


        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Before get");
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
