package com.epam.func.lesson6;

import java.time.LocalTime;

public class LocalTimeEx {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime specificTime = LocalTime.of(23, 15, 22, 122);
        System.out.println(specificTime);

        LocalTime specificTime2 = LocalTime.ofSecondOfDay(10000);
        System.out.println(specificTime2);
    }
}
