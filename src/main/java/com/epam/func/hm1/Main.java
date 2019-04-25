package com.epam.func.hm1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements CorrectTime{

    private static final Scanner scanner = new Scanner(System.in);

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
