package com.example.testovoe.api;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.innoseti.model.entity.Author;
import ru.innoseti.service.AuthorService;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @QueryMapping
    public Author authorByName(@Argument String name) {
        return authorService.getByName(name);
    }
}
