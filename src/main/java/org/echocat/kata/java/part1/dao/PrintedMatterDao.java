package org.echocat.kata.java.part1.dao;

import org.echocat.kata.java.part1.model.PrintedMatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Using simple in-memory storage.
 */
public class PrintedMatterDao {
    private Map<String, PrintedMatter> printedMatters = new HashMap<>();

    public void put(PrintedMatter pm) {
        printedMatters.put(pm.getIsbn(), pm);
    }

    public Optional<PrintedMatter> get(String isbn) {
        return Optional.ofNullable(printedMatters.get(isbn));
    }

    public List<PrintedMatter> getByAuthorEmail(String email) {
        return printedMatters.values().stream().filter(pm -> pm.hasAuthorWithEmail(email)).collect(Collectors.toList());
    }
}
