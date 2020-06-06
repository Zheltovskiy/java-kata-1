package org.echocat.kata.java.part1.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;
import org.echocat.kata.java.part1.exception.CriticalApplicationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class CsvService {
    private static final CSVFormat CSV_FORMAT = CSVFormat.RFC4180.withDelimiter(';').withHeader().withSkipHeaderRecord();
    private static final String CAN_NOT_READ_FILE_ERROR = "Can not read file %s; application will be terminated";

    public List<CSVRecord> readFile(String filePath) {
        try (InputStream is = new FileInputStream(filePath)) {
            CSVParser parser = CSVParser.parse(newReader(is), CSV_FORMAT);
            List<CSVRecord> records = parser.getRecords();
            log.debug("File {} was read, total records: {}", filePath, records.size());
            return records;
        } catch (IOException e) {
            String message = String.format(CAN_NOT_READ_FILE_ERROR, filePath);
            log.error(message);
            throw new CriticalApplicationException(message);
        }
    }

    public InputStreamReader newReader(final InputStream inputStream) {
        return new InputStreamReader(new BOMInputStream(inputStream), StandardCharsets.UTF_8);
    }
}
