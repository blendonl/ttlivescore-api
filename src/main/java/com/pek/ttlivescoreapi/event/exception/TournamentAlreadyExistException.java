package com.pek.ttlivescoreapi.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TournamentAlreadyExistException extends RuntimeException {
    public TournamentAlreadyExistException() {
        super("Tournament already exist");
    }
}
