package org.echocat.kata.java.part1.service;

import org.junit.Test;

public class PrintedMatterServiceTest {
    private PrintedMatterService service = new PrintedMatterService();

    @Test
    public void testTheDataIsReadWithoutException() {
        service.readResources();
    }
}
