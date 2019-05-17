package com.epam.func.hw1;


public class TrafficLight {
  private Color currentColor;

  public TrafficLight(Color color) {
    this.currentColor = color;
  }

  public void start() {
    while (true) {
      System.out.println("Current color is: " + currentColor);
      Thread counterThread = new Thread(counter(currentColor));
      counterThread.start();
      try {
        counterThread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException("Something went wrong!");
      }
      currentColor = getNextColor(currentColor);
    }
  }

  private Color getNextColor(Color currentColor) {
    return currentColor == Color.RED ? Color.YELLOW : currentColor == Color.YELLOW ? Color.GREEN : Color.RED;
  }

  private Runnable counter(Color color) {
    return () -> {
      int waitingTime = color.getTimeInMilliseconds();
      while (waitingTime != 0) {
        waitingTime-=1000;
        System.out.println(waitingTime/1000 + " seconds remaining.");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
  }
}
