package com.epam.func.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AnyOf {

  public static void main(String[] args) {
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
      List<Integer> list;
      for (int i = 0; i < 1_000_000; i++) {
        list = new ArrayList<>();
        list.add(i);
      }
      return "future 1";
    });

    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
      List<Integer> list;
      for (int i = 0; i < 1_000_000; i++) {
        list = new ArrayList<>();
        list.add(i);
      }
      return "future 2";
    });

    CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
      List<Integer> list;
      for (int i = 0; i < 1_000_000; i++) {
        list = new ArrayList<>();
        list.add(i);
      }
      return "future 3";
    });

    CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);
    try {
      System.out.println(anyOfFuture.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
