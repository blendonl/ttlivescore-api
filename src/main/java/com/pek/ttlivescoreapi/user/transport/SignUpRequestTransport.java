package com.pek.ttlivescoreapi.user.transport;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SignUpRequestTransport {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private char gender;
    private String email;
    private String password;
}
