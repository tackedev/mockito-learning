package com.tackedev.mockito.test_doubles.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    private static final Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
