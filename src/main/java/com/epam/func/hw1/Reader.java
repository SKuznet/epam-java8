package com.epam.func.hw1;

import java.util.Scanner;

public class Reader {

    private Scanner scanner;

    Reader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
