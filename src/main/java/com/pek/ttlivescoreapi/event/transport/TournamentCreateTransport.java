package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentCreateTransport {

    private String name;
    private String category;
}
