package com.epam.func.lesson2.cats;

public class Cat {
    private String name;
    private boolean isHungry;
    private boolean isHerbivore;

    public Cat(String name, boolean isHungry, boolean isHerbivore) {
        this.name = name;
        this.isHungry = isHungry;
        this.isHerbivore = isHerbivore;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public boolean isHerbivore() {
        return isHerbivore;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
