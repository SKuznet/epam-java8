package com.epam.func.com.epam.func.myselflesson3;

import java.util.function.Function;

public class FunctionalCompositionExample {
    public static void main(String[] args) {
        Function<String, String> action = String::trim;
        String result = action
                .andThen(String::toLowerCase)
                .andThen(StringBuffer::new)
                .andThen(StringBuffer::reverse)
                .andThen(StringBuffer::toString)
                .apply("EcneRefer");

        System.out.println(result);
    }
}
