package ru.innoseti;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innoseti.model.entity.Author;
import ru.innoseti.repository.AuthorRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;

class AuthorRepositoryTest extends IntegrationTestBase {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testSaveAuthor() {
        authorRepository.save(new Author("Oleg"));
        assertFalse(authorRepository.findById(1L).isEmpty());
    }

    @Test
    void testGetAuthor() {
        authorRepository.save(new Author("Igor"));
        assertFalse(authorRepository.findByName("Igor").isEmpty());
    }
}
