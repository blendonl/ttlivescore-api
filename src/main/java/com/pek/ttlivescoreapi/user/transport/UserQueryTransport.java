package com.pek.ttlivescoreapi.user.transport;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryTransport {
    private String firstName;
    private String lastName;
    private String email;
    private long nt;
}
