package hw2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AllOf {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> number1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return randomNumber();
        });

        CompletableFuture<Integer> number2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return randomNumber();
        });

        CompletableFuture<Integer> number3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return randomNumber();
        });

        CompletableFuture<Void> result = CompletableFuture.allOf(number1, number2, number3);
        result.get();
        System.out.println("Все числа выбраны");
    }

    private static Integer randomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(10);
        System.out.println(Thread.currentThread() + " " + number);
        return number;
    }
}
