package com.epam.func.hm1;

public class Main implements CorrectTime{

    public static void main(String[] args) {

        int time = 0;

        while (true) {
            time = CorrectTime.getIntTime();
            if (time > 60) {
                time %= 60;
            }
            Trafficlight.printColor(time);
        }
    }
}
