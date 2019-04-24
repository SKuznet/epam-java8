package lesson3;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("example");
       // Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent());
        System.out.println(optional.orElse("other"));

        optional.ifPresent((s -> System.out.println(s.charAt(0))));
    }
}
