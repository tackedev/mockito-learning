package com.tackedev.mockito.test_doubles.spy;

public class SpyBookRepository implements BookRepository {

    private int saveCalled = 0;
    private Book lastAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public int timeCalled() {
        return saveCalled;
    }

    public boolean calledWith(Book book) {
        return lastAddedBook.equals(book);
    }

}
