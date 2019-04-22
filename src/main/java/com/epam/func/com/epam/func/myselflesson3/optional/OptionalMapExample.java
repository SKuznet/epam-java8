package com.epam.func.com.epam.func.myselflesson3.optional;

import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalMapExample {
    public static void main(String[] args) {
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        Optional<Optional<String>> nonEmptyPptionalGender = Optional.of(Optional.of("female"));

        System.out.println("Optional value: " + nonEmptyGender);
//        System.out.println("Optional value: " + nonEmptyGender.map(g -> g.));

    }
}
