package hw1;


import java.util.Optional;
import java.util.Scanner;

public class Process {

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите колличество минут (для выхода введите q)");
                String input = scanner.nextLine();
                Optional<String> optional = Optional.of(input);
                if(optional.isPresent()) {
                    char ch = input.charAt(0);
                    if (Character.isDigit(ch)) {
                        try {
                            int number = Integer.parseInt(input);
                            System.out.println(number);
                            showLight(number);
                        } catch (NumberFormatException e) {
                            e.getMessage();
                        }
                    } else if (ch == 'q'){
                        break;
                    } else {
                        System.out.println("Вы ввели неправильное число");
                    }
                } else {
                    System.out.println("Значение = null");
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
}
