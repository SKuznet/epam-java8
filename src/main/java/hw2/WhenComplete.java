package hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class WhenComplete {
    public static void main(String[] args) {
        CompletableFuture<String> number1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "поток 1";
        });

        CompletableFuture<String> number2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "поток 2";
        });

        number1.whenComplete((number, ex) -> {
            if (ex == null) {
                System.out.println("Завершился " + number);
            } else {
                ex.getCause();
            }
        });

        number2.whenComplete((number, ex) ->  {
            if (ex == null) {
                System.out.println("Завершился " + number);
            } else {
                ex.getCause();
            }
        });

        try {
            CompletableFuture.allOf(number1, number2).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
