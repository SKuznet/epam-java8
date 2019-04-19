package com.epam.func.lesson2.generic;

public class Cat {
    private int speed;
    private String name;
    private boolean isHungry;
    private boolean isHerbivore;
    public Cat(int speed, String name, boolean isHungry, boolean isHerbivore) {
        this.speed = speed;
        this.name = name;
        this.isHungry = isHungry;
        this.isHerbivore = isHerbivore;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public boolean isHerbivore() {
        return isHerbivore;
    }

    public boolean isHungry() {
        return isHungry;
    }
}
