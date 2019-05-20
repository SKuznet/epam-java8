package com.epam.func.lesson5;

import java.util.concurrent.*;

public class CompletableFutureEx1 {
    public static void main(String[] args) throws InterruptedException {
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hi with ForkJoinPool");
//        try {
//            System.out.println(future1.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Hi with newCachedThreadPool", Executors.newCachedThreadPool());
//        try {
//            System.out.println(future2.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Hi with newFixedThreadPool", executor);
//        try {
//            System.out.println(future3.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        executor.shutdown();

        CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hi from another thread!");
        });

        TimeUnit.SECONDS.sleep(2);

//        try {
//            future4.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("1");
    }
}
