package com.tackedev.mockito.test_doubles.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockBookRepository implements BookRepository {

    private int saveCalled = 0;
    private Book lastAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public void verify(Book book, int times) {
        assertEquals(times, saveCalled);
        assertEquals(book, lastAddedBook);
    }

}
