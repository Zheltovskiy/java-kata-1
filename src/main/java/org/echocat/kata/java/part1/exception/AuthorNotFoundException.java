package org.echocat.kata.java.part1.exception;

public class AuthorNotFoundException extends RuntimeException {
    public static final String MESSAGE_TEMPLATE = "Can not find author by email %s";

    public AuthorNotFoundException(String email) {
        super(String.format(MESSAGE_TEMPLATE, email));
    }
}
