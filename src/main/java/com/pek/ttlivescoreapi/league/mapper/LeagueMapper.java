package com.pek.ttlivescoreapi.league.mapper;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;

import java.util.List;

public class LeagueMapper {

    public static LeagueTransport toLeagueDto(League league) {
       return LeagueTransport.builder()
               .name(league.getName())
               .build();
    }

    public static League toLeague(LeagueTransport leagueDto) {
        return League
                .builder()
                .name(leagueDto.getName())
                .build();
    }

    public static List<LeagueTransport> toLeaguesDto(List<League> leagues) {
        return leagues.stream().map(LeagueMapper::toLeagueDto).toList();
    }
}
