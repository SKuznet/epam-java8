package com.epam.func.com.epam.func.myselflesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class FunctionReferenceExample {
    public static void main(String[] args) throws IOException {
        Function<String, Integer> function = s -> parse(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Integer digit = function.apply(input);
        System.out.println("Square" + digit * digit + "with liambda");

        Function<String, Integer> function2 = FunctionReferenceExample::parse;
        Integer digit2 = function.apply(input);
        System.out.println("Square" + digit2 * digit2 + "with liambda");
    }

    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
