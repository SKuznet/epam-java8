package com.epam.func.com.epam.func.myselflesson3;

public interface FunctionalInterface1 {
    default void sayHellow() {
        System.out.println("Hello");
    }

    static void getInfo() {
        System.out.println("Hello from static method from interface");
    }

}
