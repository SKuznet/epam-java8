package com.epam.func.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Barsik", "Murzik", "Riska", "Riska");

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list1.add(i);
        }

        System.out.println(list.stream().findFirst().orElse("1"));

        System.out.println(list.stream().findAny().orElse("1"));

        System.out.println(list.stream().filter((s) -> s.contains("a")).collect(Collectors.toList()));

        System.out.println(list.stream().filter("Barsik"::equals).count());

        System.out.println(list.stream().anyMatch("Barsik"::equals));
        System.out.println(list.stream().anyMatch("Snegok"::equals));

        System.out.println(list.stream().noneMatch("Snegok"::equals));

        System.out.println(list.stream().allMatch((s) -> s.contains("i")));

        System.out.println(list.stream().min(String::compareTo));

        System.out.println(list.stream().max(String::compareTo));

        list.stream().forEach(System.out::println);

        list.stream().forEachOrdered(System.out::println);

        System.out.println(Arrays.toString(list.stream().map(String::toUpperCase).toArray(String[]::new)));

        System.out.println(list.stream().reduce((s1, s2) -> s1 + "_" + s2).orElse("1"));
    }
}
