package com.epam.func.hw1;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class Main {
    static int INVALID_VALUE = -1;
    public static void main(String[] args) {
        System.out.println("Enter the minute for which you want to get the " +
                "color of the traffic light");
        Scanner keyboard = new Scanner(System.in);
        IntPredicate  filterInputValue = (e) -> {
            if (e != INVALID_VALUE && e > 0) {
                return true;
            } else {
                System.out.println("Wrong input, try again");
                return false;
            }
        };
        Function<String,Integer> parseInteger = (str) -> {
            try {
                return Integer.parseInt(str);
            }
            catch (NumberFormatException e) {
                return INVALID_VALUE;
            }
        };
        Stream.generate(keyboard::nextLine)
                .mapToInt(parseInteger::apply)
                .filter(filterInputValue)
                .mapToObj(TrafficLight::getColorAfterTime)
                .forEach(System.out::println);


    }
}
