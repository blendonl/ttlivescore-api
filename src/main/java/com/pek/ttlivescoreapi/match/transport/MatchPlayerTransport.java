package com.pek.ttlivescoreapi.match.transport;


import com.pek.ttlivescoreapi.user.transport.UserTransport;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchPlayerTransport {

    private UserTransport player;
}
