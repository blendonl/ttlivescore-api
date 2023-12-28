package com.pek.ttlivescoreapi.team.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TeamNotFoundException extends RuntimeException {
    private String name;

    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException() {
        super("team not found exception");
    }
}
