package org.echocat.kata.java.part1.dao;

import lombok.AllArgsConstructor;
import org.echocat.kata.java.part1.model.Author;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Using simple in-memory storage.
 * Represents operations on authors - adding new and retrieving existing by email.
 */
public class AuthorsDao {
    private Map<String, Author> authors = new HashMap<>();

    public void put(Author author) {
        authors.put(author.getEmail(), author);
    }

    public Optional<Author> get(String email) {
        return Optional.ofNullable(authors.get(email));
    }
}
