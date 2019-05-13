package com.epam.func.lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamExample3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "5", "8", "13");

        System.out.println(list.stream().mapToInt(Integer::parseInt).sum());

        System.out.println(list.stream().mapToInt(Integer::parseInt).average());

        IntStream intStream = IntStream.range(1, 5);
        intStream.mapToObj(Long::valueOf).forEach(System.out::println);

        IntStream intStream2 = IntStream.range(1, 5);
        intStream2.boxed().forEach(System.out::println);

    }


}
