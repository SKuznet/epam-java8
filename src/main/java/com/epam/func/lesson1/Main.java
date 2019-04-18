package com.epam.func.lesson1;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Welcome to func!");

        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Welcome!");
            }
        };

        new Thread(runnable).start();
    }
}
