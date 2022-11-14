package ru.innoseti;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class InnosetiApplication {
    public static void main(String[] args) {
        SpringApplication.run(InnosetiApplication.class, args);
    }
}
