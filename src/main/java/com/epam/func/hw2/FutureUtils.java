package com.epam.func.hw2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class FutureUtils {
    CompletableFuture<String> getStringCompletableFuture(Logger LOGGER, Long timeToSleepMS, String nameOfFuture) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(timeToSleepMS);
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARNING, "Interrupt problem with" + nameOfFuture + "future");
            }
            return nameOfFuture + " future showed up!";
        });
    }
}
