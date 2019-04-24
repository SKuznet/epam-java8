package com.epam.homeworks.hw1;

/**
 * Сфетофор - у которого три цвета(красный, желтый, зеленый)
 * Красный свет у светофора загорается первым и горит 2 минуты
 * Желтый свет второй и горит 1 минуту
 * Зеленый свет третий и горит 3 минуты
 */
public class Main {
    public static void main(String[] args) {
        Executor executor = new Executor();

        while (true) {
            System.out.println("Insert your number");
            int number = executor.getMinute();
            String currentColor = executor.answer(number);
            System.out.println("Current color is " + currentColor);
        }
    }
}
