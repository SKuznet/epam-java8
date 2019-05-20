package hw1;


import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class Process implements Runnable{

    @Override
    public void run() {
        start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите колличество минут (для выхода введите q)");
                String input = scanner.nextLine();
                Optional<String> optional = Optional.of(input);
                if(optional.isPresent() && !(optional.get().equals(""))) {
                    char ch = optional.get().charAt(0);
                    if (Character.isDigit(ch)) {
                        try {
                            Function<String, Integer> toInteger = string -> parse(string);
                            Integer integer = toInteger.apply(input);
                            System.out.println(integer);
                            showLight(integer);
                        } catch (NumberFormatException e) {
                            e.getMessage();
                        }
                    } else if (ch == 'q'){
                        break;
                    } else {
                        System.out.println("Вы ввели неправильное число");
                    }
                } else {
                    System.out.println("Вы ввели неправильное число");
                }
            }
        }
    }

    private void showLight(Integer number) {
        Light light;
        int num = number % 6;
        if (num < Light.RED.getTime()) {
            light = Light.RED;
        } else if (num < Light.YELLOW.getTime()) {
            light = Light.YELLOW;
        } else {
            light = Light.GREEN;
        }
        System.out.println(light);
    }

    private Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
