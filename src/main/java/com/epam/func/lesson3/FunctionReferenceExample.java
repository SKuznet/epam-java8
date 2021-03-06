package com.epam.func.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class FunctionReferenceExample {

    public static void main(String[] args) throws IOException {
        Function<String, Integer>  toInteger = s -> parse(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Integer digital = toInteger.apply(input);
        System.out.println("Square of " + digital * digital + " with lyambda");

        Function<String, Integer> toInteger2 = FunctionReferenceExample::parse;
        Integer digital2 = toInteger2.apply(input);
        System.out.println("Square of " + digital2 * digital2 + " with reference");
    }

    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
