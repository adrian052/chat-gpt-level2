package com.gpt.chatgptlevel2.service;

import com.gpt.chatgptlevel2.entity.Book;
import com.gpt.chatgptlevel2.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testGetBookById() {
        // Mock data
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Sample Book");

        // Mock the repository behavior
        Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // Test the service method
        Book result = bookService.getBookById(bookId);

        // Assertions
        assertNotNull(result);
        assertEquals(bookId, result.getId());
        assertEquals("Sample Book", result.getTitle());
    }

    @Test
    public void testCreateBook() {
        // Mock data
        Book book = new Book();
        book.setTitle("New Book");

        // Mock the repository behavior
        Mockito.when(bookRepository.save(book)).thenReturn(book);

        // Test the service method
        Book result = bookService.createBook(book);

        // Assertions
        assertNotNull(result);
        assertEquals("New Book", result.getTitle());
    }

    @Test
    public void testUpdateBook() {
        // Mock data
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Sample Book");

        Book updatedBook = new Book();
        updatedBook.setId(bookId);
        updatedBook.setTitle("Updated Book");

        // Mock the repository behavior
        Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        Mockito.when(bookRepository.save(updatedBook)).thenReturn(updatedBook);

        // Test the service method
        Book result = bookService.updateBook(bookId, updatedBook);

        // Assertions
        assertNotNull(result);
        assertEquals(bookId, result.getId());
        assertEquals("Updated Book", result.getTitle());
    }

    @Test
    public void testDeleteBook() {
        // Mock data
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);

        // Mock the repository behavior
        Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // Test the service method
        boolean deleted = bookService.deleteBook(bookId);

        // Assertions
        assertTrue(deleted);
    }
}
