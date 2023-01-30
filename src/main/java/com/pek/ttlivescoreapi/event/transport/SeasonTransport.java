package com.pek.ttlivescoreapi.event.transport;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.dto.LeagueDto;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonTransport {
    private String name;
    private Date date;
    private LeagueDto leagueDto;
}
