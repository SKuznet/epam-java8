package com.epam.func.lesson6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateApiEx {
    public static void main(String[] args) {
        LocalDate year = LocalDate.now();

        System.out.println("Текущий год високосный " + year.isLeapYear());

        System.out.println("Сегодня - это до 14.05.2019 " + year.isBefore(LocalDate.of(2019, 5, 14)));

        System.out.println("Текущее время " + year.atTime(LocalTime.now()));

        System.out.println(year.plusDays(5));
        System.out.println(year.plusWeeks(5));
        System.out.println(year.plusMonths(4));
        System.out.println(year.plusYears(5));

        System.out.println(year.minusMonths(3));

        LocalDate firstDayOfNextMonth = year.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(year.with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek());

        Period period = year.until(firstDayOfNextMonth);

        System.out.println(period.getDays());
    }
}
