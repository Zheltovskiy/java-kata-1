package org.echocat.kata.java.part1.exception;

public class CriticalApplicationException extends RuntimeException {
    public CriticalApplicationException(String message) {
        super(message);
    }
}
