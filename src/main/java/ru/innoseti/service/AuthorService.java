package ru.innoseti.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innoseti.model.entity.Author;
import ru.innoseti.model.exception.NotFoundEntityException;
import ru.innoseti.repository.AuthorRepository;
import ru.innoseti.repository.BookRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Author getByName(String name) {
        return authorRepository.findByName(name).orElseThrow(() -> new NotFoundEntityException("Автора с таким именем нету"));
    }

    public Author save(String title, List<Long> booksId) {
        return authorRepository.save(new Author(title, bookRepository.findAllById(booksId)));
    }
}
