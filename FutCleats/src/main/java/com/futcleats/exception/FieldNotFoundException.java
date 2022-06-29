package com.futcleats.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class FieldNotFoundException extends RuntimeException {

    public FieldNotFoundException(String message) {
        super(message);
    }
}
