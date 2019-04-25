package com.epam.func.homework1;

/**
 * Created by vladd on 25.04.2019
 */

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight(TrafficLight::checkLightColor);
        int number;
        quit:
        while (true) {
            System.out.println("Please enter a positive number!");
            System.out.println("To exit enter 'q'");

            while (!scanner.hasNextInt()) {
                if (scanner.next().equals("q")) {
                    break quit;
                }
                System.out.println("That not a number!");
            }
            number = scanner.nextInt();
            if (number <= 0) {
                continue;
            }
            trafficLight.printColor(number);
        }
    }
}
