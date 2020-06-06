package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.PrintedMatter;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrintedMatterServiceTest {
    private static final String TEST_ISBN = "1024-5245-8584";
    private static final String TEST_EMAIL = "null-walter@echocat.org";
    private PrintedMatterService service = new PrintedMatterService();

    @Before
    public void testTheDataIsReadWithoutException() {
        service.readResources();
    }

    @Test
    public void checkPrintedMattersAreFoundByEmail() {
        List<PrintedMatter> printedMatterByAuthorEmail = service.findPrintedMatterByAuthorEmail(TEST_EMAIL);
        assertEquals(6, printedMatterByAuthorEmail.size());

    }

    @Test
    public void checkBookIsFoundByIsbn() {
        PrintedMatter printedMatterByIsbn = service.findPrintedMatterByIsbn(TEST_ISBN);
        assertEquals(TEST_ISBN, printedMatterByIsbn.getIsbn());
    }
}
