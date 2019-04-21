package com.epam.func.homework.hw1;

public enum Light {
    RED,
    YELLOW,
    GREEN;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public String toString() {
        switch (this) {
            case RED:
                return ANSI_RED + RED.name() + ANSI_RESET;
            case YELLOW:
                return ANSI_YELLOW + YELLOW.name() + ANSI_RESET;
            case GREEN:
                return ANSI_GREEN + GREEN.name() + ANSI_RESET;
            default:
                return this.name();
        }
    }
}
