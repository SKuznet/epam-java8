package com.epam.func.hw1;


public class TrafficLight {

  private Color currentColor = Color.RED;

  public void start() {
    while (true) {
      System.out.println("Current color is: " + currentColor);
      counter(currentColor);
      currentColor = getNextColor(currentColor);
    }
  }

  private Color getNextColor(Color currentColor) {
    return currentColor == Color.RED ? Color.YELLOW
        : currentColor == Color.YELLOW ? Color.GREEN : Color.RED;
  }

  private void counter(Color color) {
    int waitingTime = color.getTimeInMilliseconds();
    while (waitingTime != 0) {
      waitingTime -= 1000;
      System.out.println(waitingTime / 1000 + " seconds remaining.");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
