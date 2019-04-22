package com.epam.func.com.epam.func.myselflesson3;

import java.sql.SQLOutput;

public class Impl implements FunctionalInterface1, FunctionalInterface2 {
    public static void main(String[] args) {
        FunctionalInterface1.getInfo();
        Impl impl = new Impl();
        impl.sayHellow();
    }

    @Override
    public void sayHellow() {
        System.out.println("We are the best!!!");
    }
}
