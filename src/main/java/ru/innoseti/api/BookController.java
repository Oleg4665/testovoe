package ru.innoseti.api;


import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.innoseti.model.entity.Book;
import ru.innoseti.service.BookService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public List<Book> getBooksByAuthor(@Argument Long authorsId) {
        return bookService.getBooksByAuthor(authorsId);
    }

    @MutationMapping
    public Book addBook(@Argument String title, @Argument List<Long> authorsId) {
        return bookService.saveBook(title, authorsId);
    }
}
