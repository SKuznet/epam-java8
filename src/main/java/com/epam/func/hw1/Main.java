package com.epam.func.hw1;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.epam.func.hw1.SignalLight.LOOP_DURATION;

public class Main {
    public static void main(String[] args) {
        SignalLightImpl trafficLight = new SignalLightImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a minute: ");
        while (true) {
            try {
                int minute = scanner.nextInt() % LOOP_DURATION;
                if (minute < 0) {
                    throw new IllegalArgumentException();
                }
                System.out.println(trafficLight.checkColor(minute));
                System.out.println("\nDo it again! \nEnter a minute: ");
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.print("\nPlease enter a valid number: ");
                scanner.next();
            }
        }
    }
}
