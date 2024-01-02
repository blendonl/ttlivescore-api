package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TournamentShortTransport {
    private long id;
    private String name;
    private String category;
    private Date date;
}
