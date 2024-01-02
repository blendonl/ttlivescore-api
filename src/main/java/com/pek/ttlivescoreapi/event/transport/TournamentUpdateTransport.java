package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentUpdateTransport {
    private String name;
    private Date date;
}
