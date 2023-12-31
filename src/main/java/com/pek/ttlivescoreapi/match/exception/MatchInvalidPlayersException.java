package com.pek.ttlivescoreapi.match.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MatchInvalidPlayersException extends RuntimeException {
    public MatchInvalidPlayersException() {
        super("Invalid match player number");
    }
}
