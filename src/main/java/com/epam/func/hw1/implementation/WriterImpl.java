package com.epam.func.hw1.implementation;

import com.epam.func.hw1.Writer;
import com.epam.func.hw1.util.Light;

public class WriterImpl implements Writer {

    private final String resetColor = "\u001B[0m";

    private WriterImpl() {
    }

    public void writeAnsToConsole(Light light) {
        System.out.println("Current light: " + light.toString() + resetColor);
    }

    public void writeMsgToConsole(String msg) {
        System.out.println(msg);
    }

    private static class WriterHolder {
        private static final WriterImpl WRITER_INSTANCE = new WriterImpl();
    }

    public static WriterImpl getInstance() {
        return WriterHolder.WRITER_INSTANCE;
    }
}
