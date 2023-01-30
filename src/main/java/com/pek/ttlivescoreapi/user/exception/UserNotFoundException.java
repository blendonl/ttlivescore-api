package com.pek.ttlivescoreapi.user.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends Throwable {
    private String email;
}
