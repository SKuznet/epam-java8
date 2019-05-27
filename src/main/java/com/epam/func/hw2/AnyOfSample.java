package com.epam.func.hw2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AnyOfSample {
    public static void createArray() {
        int[][] a = new int[1000][1000];
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rnd.nextInt(10) + 1;
            }
        }
    }

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            createArray();
            return "Result of Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            createArray();
            return "Result of Future 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            createArray();
            return "Result of Future 3";
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);
        try {
            System.out.println(anyOfFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
