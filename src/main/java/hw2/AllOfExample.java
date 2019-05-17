package hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AllOfExample {
    public static void main(String[] args) {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "A is here";
        });
        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "B is here";
        });


        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(a, b);
        try {
            System.out.println(a.isDone());
            System.out.println(b.isDone());
            System.out.println(completableFuture.isDone());
            completableFuture.get();
            System.out.println(a.isDone() + "   " + a.get());
            System.out.println(b.isDone() + "   " + b.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
