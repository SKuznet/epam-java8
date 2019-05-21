package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllOfExample {
    public static void main(String[] args){
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Just");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Be");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "Happy");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("future1 is done: " + future1.isDone());
        System.out.println("future2 is done: " + future2.isDone());
        System.out.println("future3 is done: " + future3.isDone());

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println("combined equals 'Hello Beautiful World': " +
                combined.equals("Hello Beautiful World"));
    }
}
