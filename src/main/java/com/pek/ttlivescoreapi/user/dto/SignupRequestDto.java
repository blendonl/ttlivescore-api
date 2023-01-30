package com.pek.ttlivescoreapi.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SignupRequestDto {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private char gender;
    private String email;
    private String password;
}
