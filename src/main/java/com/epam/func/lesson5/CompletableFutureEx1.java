package com.epam.func.lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx1 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hi with ForkJoinPool.");
        try {
            System.out.println(future1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Hi with new CacheThreadPool.",
                Executors.newCachedThreadPool());
        try {
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Hi with new FixedThreadPool.",
                executor);
        try {
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
