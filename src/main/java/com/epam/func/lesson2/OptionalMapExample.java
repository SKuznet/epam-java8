package com.epam.func.lesson2;

import java.util.Optional;

public class OptionalMapExample {
    public static void main(String[] args) {
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String>  emptyGender = Optional.empty();

        System.out.println("Non-empty optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty optional:: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("female"));

        System.out.println("Optional value: " + nonEmptyOptionalGender);
        System.out.println("Optional value: " + nonEmptyOptionalGender.map(g -> g.map(String::toUpperCase)));
    }
}
