package com.gpt.chatgptlevel2.repository;

import com.gpt.chatgptlevel2.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // You can add custom query methods here if needed
}