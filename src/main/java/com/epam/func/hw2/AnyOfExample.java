package com.epam.func.hw2;

import java.util.concurrent.*;

public class AnyOfExample {
    public static void main(String[] args){
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

        try {
            System.out.println(CompletableFuture.anyOf(cf1, cf2).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
