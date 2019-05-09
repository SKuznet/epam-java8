package com.epam.func.lesson5;

import java.util.concurrent.*;

public class CompletableFuture1 {
    public static void main(String[] args) {
        //CompletableFuture<String> future = CompletableFuture.supplyAsync(()->"hi forkjoinpool");


//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->"Hi with newCachedThreadPool", Executors.newCachedThreadPool());
//        try {
//            System.out.println(future2.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        ExecutorService executor =   Executors.newFixedThreadPool(10);
//        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->"Hi with newFixedThreadPool"
//                ,executor);
//        try {
//            System.out.println(future3.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        executor.shutdown();


        CompletableFuture<Void> future4 = CompletableFuture.runAsync(()-> System.out.println("Hi with newFixedThreadPool"));

        try {
           future4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
