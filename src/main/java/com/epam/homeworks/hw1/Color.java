package com.epam.homeworks.hw1;

public enum Color {
    RED("Red"), GREEN("Green"), YELLOW("Yellow");

    Color(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
