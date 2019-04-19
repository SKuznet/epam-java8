package com.epam.func.lesson2.generic;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat(20, "Barsik", true, true);
        Cat murzik = new Cat(30, "Murzik", true, false);

        print(barsik, O -> O.getSpeed());
        print(murzik, O -> O.getSpeed());
        print(barsik, O -> O.isHungry());
        print(murzik, O -> O.isHungry());
    }

    private static void printSpeed(Cat cat, CheckSpeed checkSpeed) {
        System.out.println(checkSpeed.get(cat));
    }

    private static void printHungryStatus(Cat cat, CheckHungry checkHungry) {
        System.out.println(checkHungry.get(cat));
    }

    private static void print(Cat cat, Check check) {
        System.out.println(check.get(cat));
    }
}
