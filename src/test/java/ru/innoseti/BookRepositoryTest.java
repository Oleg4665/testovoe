package ru.innoseti;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innoseti.model.entity.Author;
import ru.innoseti.model.entity.Book;
import ru.innoseti.repository.AuthorRepository;
import ru.innoseti.repository.BookRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BookRepositoryTest extends IntegrationTestBase{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testGetAllByAuthors() {
        Author author = new Author("Ivan");
        Book book = new Book("title");

        author.getBooks().add(book);
        book.getAuthors().add(author);

        bookRepository.save(book);
        authorRepository.save(author);
        assertFalse(bookRepository.getAllByAuthors(author).isEmpty());
    }

    @Test
    void testGetAllBooks() {
        bookRepository.save(new Book("title"));
        assertFalse(bookRepository.findAll().isEmpty());
    }

    @Test
    void testSaveBook() {
        bookRepository.save(new Book("Boook"));
        assertFalse(bookRepository.findById(1L).isEmpty());
    }
}
