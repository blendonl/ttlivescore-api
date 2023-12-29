package com.pek.ttlivescoreapi.league.transport;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeagueCreateTransport {
    private String name;
    private String category;
}
