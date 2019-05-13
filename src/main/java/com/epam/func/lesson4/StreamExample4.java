package com.epam.func.lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("barsik", "murzik");
        Stream<String> stringStream = list.stream();

        System.out.println(stringStream.isParallel());

        stringStream.parallel().forEach(System.out::println);

        stringStream.sequential();

    }
}
