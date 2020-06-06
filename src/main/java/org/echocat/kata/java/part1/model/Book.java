package org.echocat.kata.java.part1.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Book extends PrintedMatter {
    String description;

    @Builder
    public Book(String title, String isbn, List<Author> authors, String description) {
        super(title, isbn, authors);
        this.description = description;
    }

}
