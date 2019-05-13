package com.epam.func.homework.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "I am a result", executorService);
        future.thenAcceptAsync(System.out::println);

        final CompletableFuture<String> firstStep = future.thenApplyAsync(item ->
                item + " modified");

        firstStep.thenComposeAsync(item ->
                CompletableFuture.supplyAsync(() ->
                        item + " where did this come from?"))
                .whenComplete( (obj, error)
                        -> System.out.println(obj));

        executorService.shutdown();
    }
}
