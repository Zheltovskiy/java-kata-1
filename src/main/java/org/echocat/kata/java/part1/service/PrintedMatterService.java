package org.echocat.kata.java.part1.service;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.dao.AuthorsDao;
import org.echocat.kata.java.part1.dao.PrintedMatterDao;
import org.echocat.kata.java.part1.exception.AuthorNotFoundException;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.PrintedMatter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class PrintedMatterService {
    public static final String AUTHOR_PATH = "src/main/resources/org/echocat/kata/java/part1/data/authors.csv";
    public static final String BOOK_PATH = "src/main/resources/org/echocat/kata/java/part1/data/books.csv";
    public static final String MAGAZINE_PATH = "src/main/resources/org/echocat/kata/java/part1/data/magazines.csv";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private CsvService csvService = new CsvService();
    private AuthorsDao authorsDao = new AuthorsDao();
    private PrintedMatterDao printedMatterDao = new PrintedMatterDao();

    public void readResources() {
        readAuthors();
        readBooks();
        readMagazines();
    }

    private void readMagazines() {
        csvService.readFile(MAGAZINE_PATH).stream().map(this::buildMagazine).forEach(printedMatterDao::put);
    }

    private void readBooks() {
        csvService.readFile(BOOK_PATH).stream().map(this::buildBook).forEach(printedMatterDao::put);
    }

    private void readAuthors() {
        csvService.readFile(AUTHOR_PATH).stream().map(Author::fromCsvRecord).forEach(authorsDao::put);
    }

    public Book buildBook(CSVRecord record) {
        return Book.builder()
                .title(record.get("title"))
                .isbn(record.get("isbn"))
                .authors(toAuthors(record.get("authors")))
                .description(record.get("description"))
                .build();
    }

    private Magazine buildMagazine(CSVRecord record) {
        return Magazine.builder()
                .title(record.get("title"))
                .isbn(record.get("isbn"))
                .authors(toAuthors(record.get("authors")))
                .publishedAt(LocalDate.parse(record.get("publishedAt"), DATE_TIME_FORMATTER))
                .build();
    }

    private List<Author> toAuthors(String authors) {
        return Arrays.stream(authors.split(","))
                .map(email -> authorsDao.get(email).orElseThrow(() -> new AuthorNotFoundException(email)))
                .collect(toList());
    }


}
