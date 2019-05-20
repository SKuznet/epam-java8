package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyOfTask {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        CompletableFuture<String> firstFuture =
                new FutureUtils().getStringCompletableFuture(LOGGER, 20L, "first");
        CompletableFuture<String> secondFuture =
                new FutureUtils().getStringCompletableFuture(LOGGER, 25L, "second");


        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(firstFuture, secondFuture);
        try {
            System.out.println(completableFuture.get() + "  " + completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.WARNING, "Problem with AnyOf(firstFuture, secondFuture)");
        }
    }
}
