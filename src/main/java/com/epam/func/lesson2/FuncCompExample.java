package com.epam.func.lesson2;

import java.util.function.Function;

public class FuncCompExample {
    public static void main(String[] args) {
        Function<String, String> action = String::trim;
        String res = action.andThen(String::toUpperCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply("ELPMAXE " );
        System.out.println(res);
    }

}
