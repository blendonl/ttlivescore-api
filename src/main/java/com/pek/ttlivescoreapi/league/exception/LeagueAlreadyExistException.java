package com.pek.ttlivescoreapi.league.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LeagueAlreadyExistException extends RuntimeException {
    public LeagueAlreadyExistException() {
        super("League already exist");
    }
}
