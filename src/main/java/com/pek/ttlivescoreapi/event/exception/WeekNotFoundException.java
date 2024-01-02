package com.pek.ttlivescoreapi.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WeekNotFoundException extends RuntimeException {

    public WeekNotFoundException() {
        super("Week not found");
    }
}
