package org.echocat.kata.java.part1.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
// TODO Add documentation
public abstract class PrintedMatter {
    String title;
    // TODO Validate ISBN
    String isbn;
    List<Author> authors;
}
