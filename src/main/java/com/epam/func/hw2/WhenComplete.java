package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WhenComplete {
    private static final CompletableFuture<String> gcdFuture1 = CompletableFuture.supplyAsync(Factors::getFactorizationOfRandomNumber);
    private static final CompletableFuture<String> gcdFuture2 = CompletableFuture.supplyAsync(Factors::getFactorizationOfRandomNumber);

    public static void main(String[] args) {
        CompletableFuture future1 = gcdFuture1.whenComplete(
                (result, exception) -> System.out.println("1st future result: " + result)
        );
        CompletableFuture future2 = gcdFuture2.whenComplete(
                (result, exception) -> System.out.println("2st future result: " + result)
        );
        try {
            System.out.println("Searching for a factorization...");
            future1.get();
            future2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
