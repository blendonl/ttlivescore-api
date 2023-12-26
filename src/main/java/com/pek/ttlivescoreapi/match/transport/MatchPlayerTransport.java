package com.pek.ttlivescoreapi.match.transport;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchPlayerTransport {

    private long playerId;
    private long matchId;
    private boolean isDouble;
    private boolean side;
}
