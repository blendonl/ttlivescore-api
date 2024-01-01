package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentTransport {
    private long id;
    private String name;
    private String category;
}
