package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class CompletableFutureExample {

    private ExecutorService executorService;
    private CompletableFuture<String> future1;
    private CompletableFuture<String> future2;
    private CompletableFuture<String> future3;

    CompletableFutureExample(ExecutorService executorService) {
        this.executorService = executorService;

        future1 = CompletableFuture.supplyAsync(() -> "1", executorService);
        future2 = CompletableFuture.supplyAsync(() -> "2", executorService);
        future3 = CompletableFuture.supplyAsync(() -> "3", executorService);
    }

    void anyOfExample() throws ExecutionException, InterruptedException {

        CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2, future3);

        System.out.println(result.get());
    }

    void allOfAndWhenCompleteExample() {

        CompletableFuture<Void> result = CompletableFuture.allOf(future1, future2, future3);

        result.whenComplete((a, b) -> System.out.println("hello"));
    }
}
