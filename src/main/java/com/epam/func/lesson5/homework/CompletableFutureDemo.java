package com.epam.func.lesson5.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Supplier<String> supplier = new StringSupplier();
        final List<CompletableFuture<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
            completableFuture.whenComplete((s, exc) -> System.out.println("future \"" + s + "\" ready"));
            futures.add(completableFuture);
        }

        final CompletableFuture[] futureArr = new CompletableFuture[1];
        final CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(futures.toArray(futureArr));
        System.out.println(anyFuture.get());
        System.out.println("First Future is complete in: " + System.currentTimeMillis());

        final CompletableFuture<Void> allFuture = CompletableFuture.allOf(futures.toArray(futureArr));
        System.out.println("Waiting for others: " + System.currentTimeMillis());
        allFuture.get();
        System.out.println("All futures are done: " + System.currentTimeMillis());
    }


    static class StringSupplier implements Supplier<String> {
        private static final Random RANDOM = new Random();
        private static final int MIN_AWAIT = 200;

        @Override
        public String get() {
            int delay = MIN_AWAIT + RANDOM.nextInt(300);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "waited for future for " + delay + " ms";
        }
    }
}
