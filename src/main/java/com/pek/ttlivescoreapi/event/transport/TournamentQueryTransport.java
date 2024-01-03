package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentQueryTransport {
    private long year;
    private char gender;
}
