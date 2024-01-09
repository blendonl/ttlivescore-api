package com.pek.ttlivescoreapi.user.transport;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserShortTransport {

    private String id;
    private String firstName;
    private String lastName;
    private char gender;
    private String email;
    private Date birthDate;

}
