package com.futcleats.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
