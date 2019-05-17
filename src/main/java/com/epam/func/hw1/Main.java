package com.epam.func.hw1;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.epam.func.hw1.TrafficLight.LOOP_DURATION;

public class Main {

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLightImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a minute and find out what color is lighting right now!");
        while (true) {
            try {
                int minute = scanner.nextInt() % LOOP_DURATION;
                if (minute < 0) {
                    throw new IllegalArgumentException();
                }
                System.out.println(trafficLight.checkColor(minute));
                System.out.println("\nGive it another try!");
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("\nPlease enter a valid number.");
                scanner.next();
            }
        }
    }
}
