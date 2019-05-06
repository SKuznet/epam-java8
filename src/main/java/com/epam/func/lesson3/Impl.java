package com.epam.func.lesson3;

public class Impl implements FunctionalInterface1, FunctionalInterface2 {
    public static void main(String[] args) {
        Impl impl = new Impl();
        impl.sayHello();
        FunctionalInterface1.getInfo();
    }

    @Override
    public void sayHello() {
        System.out.println("We should override it!");
    }
}
