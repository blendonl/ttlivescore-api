package com.pek.ttlivescoreapi.config.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamNotFoundException extends Exception{
    private String name;
}
