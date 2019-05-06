package com.epam.func.lesson2;

public interface FunctionalInterface1 {
    default void sayHello(){
        System.out.println("Hello");
    }

    static void getInfo(){
        System.out.println("Hello from static interface method");
    }
}
