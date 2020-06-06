package org.echocat.kata.java.part1.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class CsvService {
    private static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT.withDelimiter(';').withHeader().withSkipHeaderRecord();

    public List<CSVRecord> readFile(String filePath) throws IOException {
        File csvData = new File(filePath);
        CSVParser parser = CSVParser.parse(csvData, StandardCharsets.UTF_8, CSV_FORMAT);
        List<CSVRecord> records = parser.getRecords();
        log.debug("File {} was read, total records: {}", filePath, records.size());
        return records;
    }
}
