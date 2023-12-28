package com.pek.ttlivescoreapi.team.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TeamAlreadyExistException extends RuntimeException {
    public TeamAlreadyExistException(String message) {
        super(message);
    }

    public TeamAlreadyExistException() {
        super("Team already exist");
    }

}
