package com.epam.func.lesson3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("With L");
        List<String> list = Arrays.asList("Barsik", "Murzik", "Snegok", "Riska");
        list.forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("With R");
        list.forEach(System.out::println);
    }
}
