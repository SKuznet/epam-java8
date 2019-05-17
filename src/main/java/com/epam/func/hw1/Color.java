package com.epam.func.hw1;

public enum Color {
  RED(2),
  YELLOW(1),
  GREEN(3);

  int waitTimeInMinutes;

  Color(int waitTimeInMinutes) {
    this.waitTimeInMinutes = waitTimeInMinutes;
  }

  public int getTimeInMilliseconds() {
    return waitTimeInMinutes * 60 * 1000;
  }
}
