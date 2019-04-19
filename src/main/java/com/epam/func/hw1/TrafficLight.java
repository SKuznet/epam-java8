package com.epam.func.hw1;

import java.util.Scanner;
import java.util.concurrent.*;

public class TrafficLight {
    private Color color;
    private int minutes;

    public static void main(String[] args) throws ExecutionException {
        TrafficLight trafficLight = new TrafficLight();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number waiting minutes..");
        if (scanner.hasNextInt()) {
            trafficLight.setMinutes(scanner.nextInt());
        } else {
            throw new RuntimeException("It is not integer");
        }

        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            Callable r = (Callable<Color>) () -> {
                try {
                    do {
                        trafficLight.setColor(Color.RED);
                        TimeUnit.SECONDS.sleep(2);
                        trafficLight.setColor(Color.YELLOW);
                        TimeUnit.SECONDS.sleep(1);
                        trafficLight.setColor(Color.GREEN);
                        TimeUnit.SECONDS.sleep(3);

                    } while (!service.isShutdown());
                } catch (InterruptedException e) {
                    System.err.println("Something goes wrong...");
                }
                return trafficLight.getColor();
            };

            Future<?> f = service.submit(r);
            f.get(trafficLight.getMinutes(), TimeUnit.SECONDS);

        } catch (final InterruptedException e) {
            System.err.println("Something goes wrong...");

        } catch (final TimeoutException e) {
            System.err.println("Current color is " + trafficLight.getColor());

        } finally {
            service.shutdown();
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}