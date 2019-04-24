package hw1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleReader {
    private Scanner scanner = new Scanner(System.in);
    private LightController controller = new LightController();
    private Consumer<Double> lightControllerConsumer = s -> System.out.println(controller.getLightByMinute(s));


    public static void main(String[] args) {
       ConsoleReader consoleReader = new ConsoleReader();
       consoleReader.readFromConsole();
    }

    private void readFromConsole() {
        try {
            while (true) {
                System.out.println("Enter a minute:");
                double minute = scanner.nextDouble();
                if (minute < 0) throw new InputMismatchException("You enter negative number");
                lightControllerConsumer.accept(minute);
            }
        } catch (InputMismatchException e) {
            System.err.println("Your enter is not a number");
        }
    }
}
