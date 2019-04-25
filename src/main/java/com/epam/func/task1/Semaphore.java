package com.epam.func.task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Semaphore {
    private static final String STOP_PHRASE = "--exit";
    private final Queue<Callable<SemaphoreColor>> semaphoreThreadsQueue;
    private AtomicLong minutes;

    public Semaphore() {
        semaphoreThreadsQueue = new LinkedList<>();
        minutes = new AtomicLong();
    }

    /**
     * Init {@link #semaphoreThreadsQueue} with necessary light order (RED, YELLOW, GREEN)
     * (can be initialized with (RED,YELLOW,GREEN,YELLOW) order, like a real semaphore, just need to change the test
     */
    private void initQueue() {
        Callable<SemaphoreColor> redLightThread = () -> {
            minutes.addAndGet(-SemaphoreColor.RED.getMinsOfWaiting());
            return SemaphoreColor.RED;
        };

        Callable<SemaphoreColor> yellowLightThread = () -> {
            minutes.addAndGet(-SemaphoreColor.YELLOW.getMinsOfWaiting());
            return SemaphoreColor.YELLOW;
        };

        Callable<SemaphoreColor> greenLightThread = () -> {
            minutes.addAndGet(-SemaphoreColor.GREEN.getMinsOfWaiting());
            return SemaphoreColor.GREEN;
        };

        semaphoreThreadsQueue.clear();

        semaphoreThreadsQueue.add(redLightThread);
        semaphoreThreadsQueue.add(yellowLightThread);
        semaphoreThreadsQueue.add(greenLightThread);
    }

    /**
     * Calculate a color of the semaphore at the given minute
     *
     * @param mins minute to be calculated
     * @return a color{@link SemaphoreColor} of the semaphore
     */
    public SemaphoreColor getSemLightColor(String mins) {
        int minutesToCheck;
        try {
            minutesToCheck = Integer.parseInt(mins);
            if (minutesToCheck < 0) {
                throw new NumberFormatException("We are proceeding negative numbers the same as illegal string arguments!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cant check this input: negative minutes or the given string can't be parsed to long.");
        }
        initQueue();
        minutes.set(minutesToCheck);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        SemaphoreColor result = SemaphoreColor.RED;
        Future<SemaphoreColor> buf;

        while (minutes.get() > 0) { // probably this could be implemented better
            Callable<SemaphoreColor> currentThread = semaphoreThreadsQueue.poll();
            if (currentThread == null) {
                throw new RuntimeException("An error occurred in semaphoreThreadsQueue.");
            }
            buf = executor.submit(currentThread);
            try {
                result = buf.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.printf("An error occurred in semaphore light thread, cancel it.");
                break;
            }
            semaphoreThreadsQueue.add(currentThread);
        }
        executor.shutdown();
        return result;
    }

    public void runApp() {
        String arg;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.printf("Type in amount of minutes to check (type \"%s\" to stop): ", STOP_PHRASE);
            while (!(arg = scanner.next()).equals(STOP_PHRASE)) {
                try {
                    System.out.printf("Color of the semaphore during %s minute is %s\n", arg, getSemLightColor(arg));
                } catch (IllegalArgumentException e) {
                    System.out.printf("%s is wrong parameter!\n", arg);
                }
                System.out.printf("\nType in amount of minutes to check (type \"%s\" to stop): ", STOP_PHRASE);
            }
        } finally {
            System.out.println("\nProgram is stopped.");
        }

    }

    public static void main(String[] args) {
        new Semaphore().runApp();
    }
}
