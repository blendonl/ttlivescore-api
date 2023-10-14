package com.pek.ttlivescoreapi.match.transport;


import com.pek.ttlivescoreapi.user.transport.UserTransport;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointTransport {
    private long id;
    private UserTransport player;
    private MatchTransport match;
    private SetTransport set;
    private boolean isTeamA;
}
