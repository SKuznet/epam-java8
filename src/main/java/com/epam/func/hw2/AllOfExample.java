package com.epam.func.hw2;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllOfExample {
    public static void main(String[] args){
        Supplier<String> supplierFuture1 = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(supplierFuture1);

        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

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

        /*
        StringJoiner joiner = new StringJoiner(" ");
        for (CompletableFuture<String> stringCompletableFuture : Arrays.asList(future1, future2, future3)) {
            String join = stringCompletableFuture.join();
            joiner.add(join);
        }
        String combined = joiner.toString();
       */

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println("combined equals 'Hello Beautiful World': " +
                combined.equals("Hello Beautiful World"));
    }
}
