package com.epam.func.hm1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface CorrectTime {

    static int getIntTime() {

        Scanner in = new Scanner(System.in);
        String s = null;
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = null;

        do {
            System.out.println("Enter time: ");
            s = in.nextLine();
            m = p.matcher(s);
        } while (!m.matches());

        return Integer.parseInt(s);
    }
}
