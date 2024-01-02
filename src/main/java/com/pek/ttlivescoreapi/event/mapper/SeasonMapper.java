package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Season;
import com.pek.ttlivescoreapi.event.transport.SeasonTransport;
import com.pek.ttlivescoreapi.league.mapper.LeagueMapper;

public class SeasonMapper {

    public static SeasonTransport toSeasonTransport(Season season) {
        return SeasonTransport.builder()
                .date(season.getEvent().getDate())
                .name(season.getEvent().getName())
                .leagueTransport(LeagueMapper.toLeagueTransport(season.getLeague()))
                .build();
    }
}
