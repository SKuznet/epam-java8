package com.epam.func.lesson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream stream = Stream.of("Barsik", "Murzik");

        List<String> list = Arrays.asList("Barsik", "Murzik", "Riska");
        Stream stream1 = list.stream();

        try {
            Stream<String> stream2 = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream.builder().add("barsik").add("murzik").build();

        Stream<String> stream3 = Stream.generate(() -> "barsik");
    }
}
