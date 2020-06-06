package org.echocat.kata.java.part1.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Book extends PrintedMatter {
    public Book(String title, String isbn, List<Author> authors) {
        super(title, isbn, authors);
    }
}
