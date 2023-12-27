package com.pek.ttlivescoreapi.team.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamNotFoundException extends Exception {
    private String name;

    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException() {
        super("team not found exception");
    }
}
