package lesson2.exist;

import java.util.function.UnaryOperator;

public class OperatorExample {
    public static void main(String[] args) {
        UnaryOperator<StringBuilder> unaryOperator = sb -> sb.reverse();
        System.out.println(unaryOperator.apply(new StringBuilder("Functional interface java8")));
    }
}
