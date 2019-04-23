package com.epam.homeworks.hw1;

public class Color {
    private String color;
    private int begin;
    private int end;

    public Color(String color, int begin, int end) {
        this.color = color;
        this.begin = begin;
        this.end = end;
    }

    public String getColor() {
        return color;
    }
}