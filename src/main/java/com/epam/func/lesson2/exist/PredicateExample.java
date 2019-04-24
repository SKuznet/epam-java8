package com.epam.func.lesson2.exist;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> predicate = O -> O.isEmpty();
        System.out.println(predicate.test(""));

        BiPredicate<String, String> biPredicate = ((s, s2) -> s.equals(s2));
        System.out.println(biPredicate.test("Functional java interface", "Functional java interface"));
    }
}
