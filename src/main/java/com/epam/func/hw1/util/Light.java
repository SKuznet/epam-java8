package com.epam.func.hw1.util;

public enum Light {

    RED_LIGHT(2, "\u001B[31m"),
    YELLOW_LIGHT(1, "\u001B[33m"),
    GREEN_LIGHT(3, "\u001B[32m");

    private Integer duration;
    private String color;

    Light(Integer duration, String color) {
        this.duration = duration;
        this.color = color;
    }

    public Integer getDuration() {
        return duration;
    }

    public String toString() {
        return color + name();
    }
}
