package com.pek.ttlivescoreapi.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WeekAlreadyExistException extends RuntimeException {

    public WeekAlreadyExistException() {
        super("Week already exist");
    }
}
