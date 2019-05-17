package com.epam.func.lesson3.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional2 = Optional.of(null);

        System.out.println(optional2.orElse("asd"));
        Optional<String> optional = Optional.of("cat");
//        Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent());

        System.out.println(optional.orElse("other"));

        optional.ifPresent((s -> System.out.println(s.charAt(0))));
    }
}
