package com.epam.hw1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AppCreator appCreator = App::new;
        App app = appCreator.create();
        try {
            app.initMainLoop();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
