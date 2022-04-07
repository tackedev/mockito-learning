package com.tackedev.mockito.test_doubles.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpyTest {

    @Test
    void demoSpy() {
        SpyBookRepository bookRepository = new SpyBookRepository();
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2, bookRepository.timeCalled());
        assertTrue(bookRepository.calledWith(book2));
    }

    @Test
    void demoSpyWithMockito() {
        BookRepository bookRepository = Mockito.spy(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookRepository, Mockito.times(1)).save(book1);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book2);
    }
}