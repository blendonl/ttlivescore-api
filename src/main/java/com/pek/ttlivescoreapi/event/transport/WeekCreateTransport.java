package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeekCreateTransport {
    private Date date;
    private String name;
    private char gender;
    private long leagueId;
    private String season;
}

