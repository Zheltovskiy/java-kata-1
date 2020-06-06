package org.echocat.kata.java.part1.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.csv.CSVRecord;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Author {
    String email;
    String firstName;
    String lastName;

    public static Author fromCsvRecord(CSVRecord record) {
        return new Author(record.get("email"), record.get("firstname"), record.get("lastname"));
    }
}
