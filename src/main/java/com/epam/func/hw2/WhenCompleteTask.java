package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WhenCompleteTask {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        CompletableFuture<String> firstFuture =
                new FutureUtils().getStringCompletableFuture(LOGGER, 20L, "first");
        CompletableFuture<String> secondFuture =
                new FutureUtils().getStringCompletableFuture(LOGGER, 25L, "second");


        CompletableFuture<String> completableFutureA =firstFuture.whenComplete((result, ex) ->
                System.out.println(result + "  First Future is cool"));
        CompletableFuture<String> completableFutureB = secondFuture.whenComplete((result, ex) ->
                System.out.println(result + "  Second Future is cool"));

        try {
            completableFutureA.get();
            completableFutureB.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.WARNING, "Problem with get futures");
        }
    }
}
