package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AllOfSample {
    public static void main(String[] args) {

        CompletableFuture<String> what = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "What";
        });

        CompletableFuture<String> the = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "the";
        });

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future";
        });

        CompletableFuture<String> holds = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "holds";
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(what, the, future, holds);
        try {
            voidCompletableFuture.get();
            System.out.println("Done");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
