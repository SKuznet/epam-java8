package com.epam.func.homework2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> strings = Arrays.asList("     first", " SeCond     ", "   THIRD   ");
        System.out.println(allOfExample(strings).get());
        System.out.println(anyOfExample().get());
        System.out.println(whenCompleteExample(strings).isDone());
    }

    private static CompletableFuture<List<String>> allOfExample(List<String> strings) {
        List<CompletableFuture<String>> futures = strings.stream()
                .map(o -> CompletableFuture.supplyAsync(() -> o.toLowerCase().trim()))
                .collect(Collectors.toList());
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]));
        return allFutures.thenApply(v ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

    private static CompletableFuture<Object> anyOfExample() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Result of Future 1")
                .thenCompose(o -> CompletableFuture.supplyAsync(() -> o.concat("+1")));
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> "Result of Future 2")
                .thenAccept(o -> CompletableFuture.supplyAsync(() -> o.concat("+1")));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Result of Future 3")
                .thenApply(o -> o.concat("+1"));
        return CompletableFuture.anyOf(future1, future2, future3);

    }

    private static CompletableFuture<Void> whenCompleteExample(List<String> strings) {
        List<CompletableFuture<String>> futures = strings.stream()
                .map(o -> CompletableFuture.supplyAsync(o::toLowerCase))
                .collect(Collectors.toList());
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .whenComplete((v, th) -> futures.forEach(CompletableFuture::join));
    }

}

