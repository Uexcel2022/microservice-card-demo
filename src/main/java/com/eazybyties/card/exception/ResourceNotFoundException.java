package com.eazybyties.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(
            String resouceName, String filedName ,String fieldValue) {
        super(String.format(
                "%s not found for the given input data %s: %s", resouceName, filedName, fieldValue));
    }
}
