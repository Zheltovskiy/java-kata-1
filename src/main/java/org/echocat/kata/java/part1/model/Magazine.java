package org.echocat.kata.java.part1.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Magazine extends PrintedMatter {
    LocalDate publishedAt;

    @Builder
    public Magazine(String title, String isbn, List<Author> authors, LocalDate publishedAt) {
        super(title, isbn, authors);
        this.publishedAt = publishedAt;
    }
}
