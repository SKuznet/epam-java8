package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllOfTask {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        CompletableFuture<String> firstFuture =
                new FutureUtils().getStringCompletableFuture(LOGGER, 20L, "first");
        CompletableFuture<String> secondFuture =
                new FutureUtils().getStringCompletableFuture(LOGGER, 25L, "second");


        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(firstFuture, secondFuture);
        try {
            System.out.println(firstFuture.isDone());
            System.out.println(secondFuture.isDone());
            System.out.println(completableFuture.isDone());
            completableFuture.get();
            System.out.println(firstFuture.isDone() + "   " + firstFuture.get());
            System.out.println(secondFuture.isDone() + "   " + secondFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.WARNING, "Problem with AllOf(firstFuture, secondFuture)");
        }
    }
}
