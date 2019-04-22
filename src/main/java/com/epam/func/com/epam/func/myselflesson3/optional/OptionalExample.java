package com.epam.func.com.epam.func.myselflesson3.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalS = Optional.of("example");
//        Optional<String> optionalS = null;
//        Optional<String> optionalS = Optional.empty();
        System.out.println(optionalS.isPresent());

        System.out.println(optionalS.orElse("other")); // проверяет есть ли значение optional

        optionalS.ifPresent((s -> System.out.println(s.charAt(0))));
    }
}
