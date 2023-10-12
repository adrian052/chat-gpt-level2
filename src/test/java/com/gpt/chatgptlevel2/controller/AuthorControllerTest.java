package com.gpt.chatgptlevel2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpt.chatgptlevel2.entity.Author;
import com.gpt.chatgptlevel2.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {
    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateAuthor() throws Exception {
        // Mock data
        Author author = new Author();
        author.setName("Jane Smith");

        Mockito.when(authorService.createAuthor(author)).thenReturn(author);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(author)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane Smith"));
    }

}
