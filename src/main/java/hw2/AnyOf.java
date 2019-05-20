package hw2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AnyOf {

    public static void main(String[] args) {
        CompletableFuture<String> number1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(randomNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Завершился поток 1");
            return randomNumber() + ", поток 1";
        });

        CompletableFuture<String> number2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(randomNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Завершился поток 2");
            return randomNumber() + ", поток 2";
        });

        CompletableFuture<Object> result = CompletableFuture.anyOf(number1, number2);
        try {
            System.out.println("Первым выбрано число " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static Integer randomNumber() {
        Random rand = new Random();
        return rand.nextInt(5);
    }
}
