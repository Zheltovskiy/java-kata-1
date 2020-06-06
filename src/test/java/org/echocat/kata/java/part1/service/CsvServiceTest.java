package org.echocat.kata.java.part1.service;

import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvServiceTest {
    @Test
    public void checkTestAuthorsSizeIsExpected() throws IOException {
        CsvService service = new CsvService();
        // TODO Extract root path
        List<CSVRecord> records = service.readFile("src/test/resources/org/echocat/kata/java/part1/data/authors.csv");
        assertEquals(6, records.size());
    }
}
