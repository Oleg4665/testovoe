package ru.innoseti.service;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import ru.innoseti.model.entity.Author;
import ru.innoseti.model.entity.Book;
import ru.innoseti.model.exception.NotFoundEntityException;
import ru.innoseti.repository.AuthorRepository;
import ru.innoseti.repository.BookRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Book saveBook(String title, List<Long> authorsId) {
        return bookRepository.save(new Book(title, authorRepository.findAllById(authorsId)));
    }

    public List<Book> getAllBooks() {
        List<Book> list = bookRepository.findAll();
        if(list.isEmpty()){
            throw new NotFoundEntityException("Нету книг в базе данных");
        }
        return list;
    }

    public List<Book> getBooksByAuthor(Long id){
        return bookRepository.
                getAllByAuthors(authorRepository.findById(id).orElseThrow(() -> new NotFoundEntityException("Автора с таким id не существует")))
                .orElseThrow(() -> new NotFoundEntityException("У автора нету книг"));
    }
}
