package com.epam.func.lesson3.optional;

import java.util.Optional;

public class OptionalFilterExample {
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("FEMALE");
        Optional<String> emptyGender = Optional.empty();

        // filters

        System.out.println(gender.filter(g -> g.equals("female")));
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("female")));
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("female")));
    }
}
