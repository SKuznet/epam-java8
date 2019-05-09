package com.epam.func.lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureEx4 {
    public static void main(String[] args) {
        CompletableFuture <String> future = CompletableFuture.supplyAsync(()->"hi");
        future.thenApply(result -> {
            System.out.println(result+":)");
            return  result;
        });

        future.thenApply(result -> {
            System.out.println(result+":(");
            return  result;
        });


        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
