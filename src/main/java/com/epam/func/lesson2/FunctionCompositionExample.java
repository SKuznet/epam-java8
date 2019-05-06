package com.epam.func.lesson2;

import java.util.function.Function;

public class FunctionCompositionExample {
    public static void main(String[] args) {
        Function<String, String> action = String::trim;

        String result = action
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply("OcOcaj");

        System.out.println(result);

    }
}
