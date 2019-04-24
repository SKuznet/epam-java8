package com.epam.hw1.exception;

public class WrongInputException extends RuntimeException {
    public WrongInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputException(String message) {
        super(message);
    }
}
