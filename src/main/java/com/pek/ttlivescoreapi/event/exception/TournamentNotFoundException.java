package com.pek.ttlivescoreapi.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TournamentNotFoundException extends RuntimeException {
    public TournamentNotFoundException() {
        super("Tournament not found");
    }

}
