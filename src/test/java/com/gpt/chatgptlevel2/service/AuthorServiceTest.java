package com.gpt.chatgptlevel2.service;

import com.gpt.chatgptlevel2.entity.Author;
import com.gpt.chatgptlevel2.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthorServiceTest {
    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @Test
    public void testGetAuthorById() {
        // Mock data
        Long authorId = 1L;
        Author author = new Author();
        author.setId(authorId);
        author.setName("John Doe");

        // Mock the repository behavior
        Mockito.when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        // Test the service method
        Author result = authorService.getAuthorById(authorId);

        // Assertions
        assertNotNull(result);
        assertEquals(authorId, result.getId());
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testCreateAuthor() {
        // Mock data
        Author author = new Author();
        author.setName("Jane Smith");

        // Mock the repository behavior
        Mockito.when(authorRepository.save(author)).thenReturn(author);

        // Test the service method
        Author result = authorService.createAuthor(author);

        // Assertions
        assertNotNull(result);
        assertEquals("Jane Smith", result.getName());
    }

    @Test
    public void testUpdateAuthor() {
        // Mock data
        Long authorId = 1L;
        Author author = new Author();
        author.setId(authorId);
        author.setName("John Doe");

        Author updatedAuthor = new Author();
        updatedAuthor.setId(authorId);
        updatedAuthor.setName("Updated Name");

        // Mock the repository behavior
        Mockito.when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        Mockito.when(authorRepository.save(updatedAuthor)).thenReturn(updatedAuthor);

        // Test the service method
        Author result = authorService.updateAuthor(authorId, updatedAuthor);

        // Assertions
        assertNotNull(result);
        assertEquals(authorId, result.getId());
        assertEquals("Updated Name", result.getName());
    }

    @Test
    public void testDeleteAuthor() {
        // Mock data
        Long authorId = 1L;
        Author author = new Author();
        author.setId(authorId);

        // Mock the repository behavior
        Mockito.when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));

        // Test the service method
        boolean deleted = authorService.deleteAuthor(authorId);

        // Assertions
        assertTrue(deleted);
    }
}

