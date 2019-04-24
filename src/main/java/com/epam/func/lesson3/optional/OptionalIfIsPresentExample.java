package com.epam.func.lesson3.optional;

import java.util.Optional;

public class OptionalIfIsPresentExample {
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        if (gender.isPresent()) {
            System.out.println("Value available");
        } else {
            System.out.println("Value not available");
        }

        gender.ifPresent(g -> System.out.println("If gender option, value available"));
        emptyGender.ifPresent(g -> System.out.println("In empty gender option, value available") );
    }
}
