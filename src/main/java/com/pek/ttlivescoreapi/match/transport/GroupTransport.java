package com.pek.ttlivescoreapi.match.transport;

import com.pek.ttlivescoreapi.user.transport.UserShortTransport;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupTransport {
    private UserShortTransport player1;
    private UserShortTransport player2;
}
