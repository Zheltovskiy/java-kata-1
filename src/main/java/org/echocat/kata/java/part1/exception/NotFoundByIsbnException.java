package org.echocat.kata.java.part1.exception;

public class NotFoundByIsbnException extends RuntimeException {
    public static final String MESSAGE_TEMPLATE = "Can not find book or magazine by ISBN %s";

    public NotFoundByIsbnException(String isbn) {
        super(String.format(MESSAGE_TEMPLATE, isbn));
    }
}
