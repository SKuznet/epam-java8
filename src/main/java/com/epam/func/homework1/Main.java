package com.epam.func.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int time;
            boolean exit = false;
            while (!exit) {
                try {
                    Util.print("Enter time: ", 1);
                    time = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    Util.print("Invalid input!", 2);
                    continue;
                }

                Util.getLight(time);

                Util.print("Type 'y' for exit:", 1);
                String ans = reader.readLine();
                if (Util.checkExit(ans)) {
                    exit = true;
                }
            }
        }
    }
}
