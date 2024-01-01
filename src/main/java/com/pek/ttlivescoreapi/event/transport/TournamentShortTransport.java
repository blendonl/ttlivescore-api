package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TournamentShortTransport {
    private String name;
    private String category;
}
