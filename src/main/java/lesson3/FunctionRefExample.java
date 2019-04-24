package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class FunctionRefExample {

    public static void main(String[] args) throws IOException {
        Function<String, Integer> toInteger = s -> parse(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer digital = toInteger.apply(reader.readLine());
        System.out.println("Square of " + digital * digital + " with lambda");
    }


    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
