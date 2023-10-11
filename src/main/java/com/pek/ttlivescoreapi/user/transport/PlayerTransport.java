package com.pek.ttlivescoreapi.user.transport;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerTransport {

    private String firstName;
    private String lastName;
    private char gender;
    private String email;
    private String teamName;

}
