import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Task_2_CF_Tests {

    @Test
    public void test_anyOf(){
        List<String> messages = Arrays.asList("CF1", "CF2", "CF3");
        List<String> result = new ArrayList<>();

        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*5));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return String.format("Hi from %s!", msg);
                }))
                .collect(Collectors.toList());

        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((res, th) -> {
                     result.add(res.toString());
        });

        completableFuture.join();
        Assert.assertEquals(1, result.size());
        result.forEach(System.out::println);
        System.out.println("Test anyOf is finished.");
    }

    @Test
    public void test_allOf() {
        List<String> messages = Arrays.asList("CF1", "CF2", "CF3");
        List<String> result = new ArrayList<>();
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.supplyAsync(() -> String.format("Hi from %s!", msg)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((v, th) -> {
                    futures.forEach(cf -> {
                        try {
                           result.add(cf.get());
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    });
                });
        allOf.join();
        Assert.assertEquals(3, result.size());
        result.forEach(System.out::println);
        System.out.println("Test allOf is finished.");
    }
}
