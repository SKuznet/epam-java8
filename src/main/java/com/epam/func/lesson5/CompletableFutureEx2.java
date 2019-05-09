package com.epam.func.lesson5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureEx2 {


    public static void main(String[] args) {
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hi";
        });
    }
}