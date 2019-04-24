package lesson3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Barsik", "Murzik", "Snegok");
        list.forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("With R");
        list.forEach(System.out::println);

    }
}
