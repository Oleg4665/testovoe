package ru.innoseti.model.exception;

import lombok.Getter;
import lombok.Setter;

public class NotFoundEntityException extends RuntimeException{
    public NotFoundEntityException(String message) {
        super(message);
    }
}
