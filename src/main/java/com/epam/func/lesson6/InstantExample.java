package com.epam.func.lesson6;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(instant.toEpochMilli());
        Instant specificTime = Instant.ofEpochMilli(instant.toEpochMilli());
        System.out.println(specificTime);

        Duration duration = Duration.ofDays(5);
        System.out.println(duration.toMinutes());
    }
}
