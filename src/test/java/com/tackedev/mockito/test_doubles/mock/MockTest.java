package com.tackedev.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

class MockTest {

    @Test
    void demoMock() {
        MockBookRepository bookRepository = new MockBookRepository();
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookRepository.verify(null, 0);

        bookService.addBook(book2);
        bookRepository.verify(book2, 1);
    }

    @Test
    void demoMockWithMockito() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookRepository, Mockito.times(0)).save(book1);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book2);
    }
}