package com.epam.func.lesson2;

import java.util.Optional;

public class OptionalIfIsPresentExample {
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        if (gender.isPresent()) {
            System.out.println("Value available");
        } else {
            System.out.println("Value not available");
        }

    }
}
