package com.epam.func.lesson5;

import java.util.concurrent.*;

public class CompletableFutureExc1 {
    public static void main(String[] args) {
        CompletableFuture<String> string = CompletableFuture.supplyAsync(() -> "Hi with ForkJoinPool");

        try {
            System.out.println(string.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(
                () -> "Hi with new CachedThreadPool",
                Executors.newCachedThreadPool());

        try {
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Hi with newFixedThreadPool", executor);
        executor.shutdown();

        try {
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
