package com.epam.func.hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class WhenCompleteSample {
    public static void main(String[] args) {

        StringBuilder result = new StringBuilder("Start");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Future 1";
        });

        try {
            TimeUnit.MILLISECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        future1.whenComplete((resp, ex) -> {
            if (ex == null) {
                result.append(resp);
            }
            System.out.println(result.toString());
        });

    }
}
