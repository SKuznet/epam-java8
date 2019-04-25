package com.epam.func.task1;

/**
 * Enumeration, containing available semaphore light colors and their delays
 */
public enum SemaphoreColor {
    RED(2),
    YELLOW(1),
    GREEN(3);

    int minsOfWaiting;

    SemaphoreColor(int min) {
        this.minsOfWaiting = min;
    }

    public int getMinsOfWaiting() {
        return minsOfWaiting;
    }
}