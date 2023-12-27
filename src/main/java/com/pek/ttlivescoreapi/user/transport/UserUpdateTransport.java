package com.pek.ttlivescoreapi.user.transport;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateTransport {
    private String firstName;
    private String lastName;
    private String password;
}
