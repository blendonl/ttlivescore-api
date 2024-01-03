package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentTransport {
    private long id;
    private String name;
    private String category;
    private Date date;
}
