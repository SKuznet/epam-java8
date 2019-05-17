package hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class AnyOfExample {
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


        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(a, b);
        try {
            //Always print A
            System.out.println(completableFuture.get()+ "  " + completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
