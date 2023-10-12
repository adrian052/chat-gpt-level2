package com.gpt.chatgptlevel2.service;

import com.gpt.chatgptlevel2.entity.Genre;
import com.gpt.chatgptlevel2.repository.GenreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GenreServiceTest {
    @InjectMocks
    private GenreService genreService;

    @Mock
    private GenreRepository genreRepository;

    @Test
    public void testGetGenreById() {
        // Mock data
        Long genreId = 1L;
        Genre genre = new Genre();
        genre.setId(genreId);
        genre.setName("Mystery");

        // Mock the repository behavior
        Mockito.when(genreRepository.findById(genreId)).thenReturn(Optional.of(genre));

        // Test the service method
        Genre result = genreService.getGenreById(genreId);

        // Assertions
        assertNotNull(result);
        assertEquals(genreId, result.getId());
        assertEquals("Mystery", result.getName());
    }

    @Test
    public void testCreateGenre() {
        // Mock data
        Genre genre = new Genre();
        genre.setName("Science Fiction");

        // Mock the repository behavior
        Mockito.when(genreRepository.save(genre)).thenReturn(genre);

        // Test the service method
        Genre result = genreService.createGenre(genre);

        // Assertions
        assertNotNull(result);
        assertEquals("Science Fiction", result.getName());
    }

    @Test
    public void testUpdateGenre() {
        // Mock data
        Long genreId = 1L;
        Genre genre = new Genre();
        genre.setId(genreId);
        genre.setName("Mystery");

        Genre updatedGenre = new Genre();
        updatedGenre.setId(genreId);
        updatedGenre.setName("Thriller");

        // Mock the repository behavior
        Mockito.when(genreRepository.findById(genreId)).thenReturn(Optional.of(genre));
        Mockito.when(genreRepository.save(updatedGenre)).thenReturn(updatedGenre);

        // Test the service method
        Genre result = genreService.updateGenre(genreId, updatedGenre);

        // Assertions
        assertNotNull(result);
        assertEquals(genreId, result.getId());
        assertEquals("Thriller", result.getName());
    }

    @Test
    public void testDeleteGenre() {
        // Mock data
        Long genreId = 1L;
        Genre genre = new Genre();
        genre.setId(genreId);

        // Mock the repository behavior
        Mockito.when(genreRepository.findById(genreId)).thenReturn(Optional.of(genre));

        // Test the service method
        boolean deleted = genreService.deleteGenre(genreId);

        // Assertions
        assertTrue(deleted);
    }
}
