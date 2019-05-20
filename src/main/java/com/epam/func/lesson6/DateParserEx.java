package com.epam.func.lesson6;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParserEx {

    public static void main(String[] args) {
        LocalDate time = LocalDate.now();
        System.out.println(time);

        System.out.println(time.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(time.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDateTime dateTime = LocalDateTime.of(2019, 1, 11, 11, 11);

        System.out.println(dateTime);
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d:MMMM:uuuu HH:mm:ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        System.out.println("Стандартный формат : " + timestamp);
    }
}
