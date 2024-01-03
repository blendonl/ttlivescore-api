package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentCreateTransport {

    private String name;
    private String category;
    private char gender;
    private Date date;
}
