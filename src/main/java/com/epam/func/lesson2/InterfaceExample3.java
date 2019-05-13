package com.epam.func.lesson2;

@FunctionalInterface
public interface InterfaceExample3 extends FunctionalInterfaceExample {

    default void getInfo() {
        System.out.println("Hello!");
    }
}
