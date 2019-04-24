package lesson2.exist;


import lesson2.cats.Cat;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class SuplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Functional interface java 8";
        System.out.println(supplier.get());

        System.out.println();

        Supplier<Cat> supplier2 = () -> new Cat("Barsik", true, true);
        System.out.println(supplier2.get());
    }
}
