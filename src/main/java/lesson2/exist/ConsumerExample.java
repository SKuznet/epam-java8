package lesson2.exist;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Functional interface java 8");

        BiConsumer<String, String> biConsumer = (((s, s2) -> System.out.println(s + s2)));
        biConsumer.accept("Functional interface " , "java 8");

        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer1 = (((integer, s) -> map.put(integer, s)));
        biConsumer1.accept(1, "Item one");
        biConsumer1.accept(2, "Item two");
        System.out.println(map);
    }
}
