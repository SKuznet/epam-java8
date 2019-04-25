package com.epam.func.hm1;

public class Trafficlight {

    private static final int RED_DELAY = 2;
    private static final int YELLOW_DELAY = 1;
    private static final int GREEN_DELAY = 3;
    private static final int CYCLE = RED_DELAY + YELLOW_DELAY + GREEN_DELAY;

    public static void printColor(int time) {

        time %= CYCLE;

        switch (time) {
            case 0:
            case 1:
            case 2:
                System.out.println(Color.RED);
                break;
            case 3:
                System.out.println(Color.YELLOW);
                break;
            case 4:
            case 5:
                System.out.println(Color.GREEN);
                break;
        }
    }
}
