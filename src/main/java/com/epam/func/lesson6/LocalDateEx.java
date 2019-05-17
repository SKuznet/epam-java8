package com.epam.func.lesson6;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateEx {
    public static void main(String[] args) {
        LocalDate current = LocalDate.now();
        System.out.println(current);

        LocalDate specificDate = LocalDate.of(2017, Month.APRIL, 30);
        System.out.println(specificDate);

//        LocalDate specificDate2 = LocalDate.of(2017, Month.APRIL, 31);
//        System.out.println(specificDate2);

        LocalDate specificDate3 = LocalDate.ofYearDay(1985, 64);
        System.out.println(specificDate3);

        LocalDate specificDate4 = LocalDate.ofEpochDay(1);
        System.out.println(specificDate4);
        System.out.println(specificDate.getDayOfWeek());
    }


}
