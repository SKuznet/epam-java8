package com.epam.func.lesson2.exist;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorExample {
    public static void main(String[] args) {
        UnaryOperator<StringBuilder> unaryOperator = sb -> sb.reverse();
        System.out.println(unaryOperator.apply(new StringBuilder("Functional interface java 8")));

        BinaryOperator<StringBuilder> binaryOperator = ((sb, sb2) -> sb.append(sb2));
        System.out.println(binaryOperator.apply(new StringBuilder("Functional interface"),
                new StringBuilder(" java 8")));
    }
}
