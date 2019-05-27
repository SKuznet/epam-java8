package com.epam.func.hw2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class WhenCompleteEx {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("WHAT", "THE", "FUTURE", "HOLDS");

        long count = list.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> s + s.toLowerCase()))
                .map(f -> f.whenComplete((result, error) -> System.out.println(result + " Error:" + error)))
                .count();
        System.out.println("Count: " + count);
    }

}
