package org.echocat.kata.java.part1.exception;

public class AuthorNotFoundException extends RuntimeException {
    public static final String messageTemplate = "Can not find author by email %s";

    public AuthorNotFoundException(String email) {
        super(String.format(messageTemplate, email));
    }
}
