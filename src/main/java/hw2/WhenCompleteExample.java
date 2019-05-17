package hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class WhenCompleteExample {
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


        CompletableFuture<String> completableFutureA =a.whenComplete((result, ex) ->
                System.out.println(result + "  A is the best"));
        CompletableFuture<String> completableFutureB = b.whenComplete((result, ex) ->
                System.out.println(result + "  B is the best"));

        try {
            completableFutureA.get();
            completableFutureB.get();
        } catch (InterruptedException | ExecutionException e) {

        }
    }
}
