package com.epam.func.lesson2.exist;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Functional interface java 8";
        System.out.println(supplier.get());

        Supplier<CatInterface> supplier2 = () -> new CatInterface() {
            @Override
            public String getName() {
                return "Barsik";
            }
        };
        System.out.println(supplier2.get());
    }
}
