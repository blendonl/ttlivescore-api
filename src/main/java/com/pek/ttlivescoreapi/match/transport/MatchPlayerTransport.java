package com.pek.ttlivescoreapi.match.transport;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchPlayerTransport {
    private long playerId;
    private boolean side;
}
