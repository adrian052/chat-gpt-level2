package com.gpt.chatgptlevel2.repository;

import com.gpt.chatgptlevel2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // You can add custom query methods here if needed
}