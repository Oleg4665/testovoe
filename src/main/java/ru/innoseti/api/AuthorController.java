package ru.innoseti.api;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.innoseti.model.entity.Author;
import ru.innoseti.service.AuthorService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @MutationMapping
    public Author addAuthor(@Argument String name, @Argument List<Long> booksId) {
        return authorService.save(name, booksId);
    }

    @QueryMapping
    public Author getByName(@Argument String name) {
        return authorService.getByName(name);
    }
}
