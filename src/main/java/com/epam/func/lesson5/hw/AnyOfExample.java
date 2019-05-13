package com.epam.func.lesson5.hw;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AnyOfExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });

        System.out.println(CompletableFuture.anyOf(cf1, cf2).get());
    }
}

