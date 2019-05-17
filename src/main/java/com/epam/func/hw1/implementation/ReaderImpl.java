package com.epam.func.hw1.implementation;

import com.epam.func.hw1.Reader;

import java.util.Scanner;

public class ReaderImpl implements Reader {

    private Scanner scanner;

    private ReaderImpl() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    private static class ReaderHolder {
        private static final ReaderImpl READER_INSTANCE = new ReaderImpl();
    }

    public static ReaderImpl getInstance() {
        return ReaderHolder.READER_INSTANCE;
    }
}
