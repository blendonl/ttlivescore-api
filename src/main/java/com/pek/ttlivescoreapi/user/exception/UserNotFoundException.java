package com.pek.ttlivescoreapi.user.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private String email;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("user not found");
    }
}
