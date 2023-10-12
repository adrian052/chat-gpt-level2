package com.gpt.chatgptlevel2.repository;

import com.gpt.chatgptlevel2.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    // You can add custom query methods here if needed
}