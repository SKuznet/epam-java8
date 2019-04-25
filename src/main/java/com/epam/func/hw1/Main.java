package com.epam.func.hw1;

import com.epam.func.hw1.Utils.ReadInput;

/**
 * there is no exit...
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Please, type integer number from zero to 2_147_483_647:");
        runnable.run();
        Thread thread = new Thread(() -> new ReadInput().readFromConsole());
        thread.start();
    }
}
