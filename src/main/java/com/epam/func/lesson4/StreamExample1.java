package com.epam.func.lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Barsik", "Murzik", "Riska", "Barsik");

        System.out.println(list.stream().filter("Barsik"::equals).count());

        System.out.println(list.stream().skip(1).findFirst().orElse("1"));

        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toList()));

        System.out.println(list.stream().map(String::toLowerCase).peek((o) -> System.out.println(",, " + o)).collect(Collectors.toList()));

        System.out.println(list.stream().limit(2).collect(Collectors.toList()));

        System.out.println(list.stream().sorted().collect(Collectors.toList()));

        Stream<String> stream = Arrays.stream(new String[]{"1", "2", "4"});

        System.out.println(Arrays.toString(stream.mapToInt(Integer::parseInt).toArray()));

        Stream<String> stream2 = Arrays.stream(new String[]{"Barsik,Murzik,Snegok"});
        System.out.println(Arrays.toString(stream2.flatMap((p) -> Arrays.stream(p.split(","))).toArray(String[]::new)));
    }
}
