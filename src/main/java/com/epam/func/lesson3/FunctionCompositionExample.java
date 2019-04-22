package com.epam.func.lesson3;

import java.util.function.Function;

public class FunctionCompositionExample {
    public static void main(String[] args) {
        Function<String, String> action = String::trim;
        String result = action
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" EcneRefeR ");

        System.out.println(result);
    }
}
