package com.epam.func.lesson6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class LocalDateTimeEx {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        LocalDateTime specificDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(specificDateTime);

        LocalDateTime specificDateTime2 = LocalDateTime.of(2019, 5, 10, 22, 15);
        System.out.println(specificDateTime2);

        LocalDateTime specificDateTime3 = LocalDateTime.ofEpochSecond(35000, 0, ZoneOffset.UTC);
        System.out.println(specificDateTime3);
    }
}
