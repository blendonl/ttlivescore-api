package com.pek.ttlivescoreapi.league.mapper;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueShortTransport;

import java.util.List;

public class LeagueShortMapper {

    public static List<LeagueShortTransport> toLeagueShortTransports(List<League> leagues) {
        return leagues.stream().map(LeagueShortMapper::toLeagueShortTransport).toList();


    }

    public static LeagueShortTransport toLeagueShortTransport(League league) {

        return LeagueShortTransport.builder()
                .id(league.getId())
                .name(league.getName())
                .category(league.getCategory().name())
                .yearCreated(league.getYear())
                .teamsLength(league.getTeams() != null ? league.getTeams().size() : 0)
                .build();

    }

}
