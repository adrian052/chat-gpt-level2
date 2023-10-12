package com.gpt.chatgptlevel2.service;

import com.gpt.chatgptlevel2.entity.Genre;
import com.gpt.chatgptlevel2.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Long id, Genre updatedGenre) {
        Optional<Genre> existingGenre = genreRepository.findById(id);
        if (existingGenre.isPresent()) {
            updatedGenre.setId(id);
            return genreRepository.save(updatedGenre);
        }
        return null;
    }

    public boolean deleteGenre(Long id) {
        Optional<Genre> existingGenre = genreRepository.findById(id);
        if (existingGenre.isPresent()) {
            genreRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
