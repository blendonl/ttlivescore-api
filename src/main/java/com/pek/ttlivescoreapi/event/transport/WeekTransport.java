package com.pek.ttlivescoreapi.event.transport;

import com.pek.ttlivescoreapi.league.transport.LeagueTransport;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeekTransport {
    private String name;
    private Date date;
    private LeagueTransport leagueTransport;
}
