package com.pek.ttlivescoreapi.user.transport;

import lombok.*;

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

}
