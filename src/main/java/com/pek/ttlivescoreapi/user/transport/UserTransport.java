package com.pek.ttlivescoreapi.user.transport;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTransport {

    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private char gender;



}
