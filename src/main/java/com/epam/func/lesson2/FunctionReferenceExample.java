package com.epam.func.lesson2;

import java.util.function.Function;

public class FunctionReferenceExample {

    public static void main(String[] args) {
        Function <String, Integer> toInt1 = s ->parse(s);
        String input = "10";
        Integer digital = toInt1.apply(input);
        System.out.printf("Square of %d using lambda\n", digital*digital);



        Function <String, Integer> toInt2 = FunctionReferenceExample::parse;
        String input2 = "11";
        Integer digital2 = toInt1.apply(input2);
        System.out.printf("Square of %d using lambda\n", digital2*digital2);

    }


    private static Integer parse (String s){
        return Integer.parseInt(s);
    }
}
