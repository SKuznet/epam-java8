package com.epam.func.hm1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Trafficlight {

    private static final int RED_DELAY = 2;
    private static final int YELLOW_DELAY = 1;
    private static final int GREEN_DELAY = 3;
    private static final int CYCLE = RED_DELAY + YELLOW_DELAY + GREEN_DELAY;

    private static List<Color> colorList = Arrays.asList(Color.RED, Color.YELLOW, Color.GREEN);

    private static Optional<String> message = Optional.of("Color: ");

    public static void printColor(int time) {
        TimeCorrecting timeCorrecting = time12 -> time12 % CYCLE;

        time = timeCorrecting.correctedTime(time);

        switch (time) {
            case 0:
            case 1:
            case 2:
                message.ifPresent(s -> System.out.print(s));
                useStream(Color.RED);
                usePredicate(Color.RED);
                break;
            case 3:
                System.out.print(message.orElse("Roloc: "));
                useStream(Color.YELLOW);
                usePredicate(Color.YELLOW);
                break;
            case 4:
            case 5:
                System.out.print(message.get());
                useStream(Color.GREEN);
                usePredicate(Color.GREEN);
                break;
        }
    }

    private static void useStream(Color col) {
        colorList.stream().filter(color -> color.equals(col)).forEach(System.out::println);
    }

    private static void usePredicate(Color color) {
        Predicate<Color> predicate = (s) -> s.equals(Color.RED);
        System.out.println(predicate.test(color)? "It's Red!" : "It's not Red!");
    }
}
