package com.pek.ttlivescoreapi.league.mapper;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueCreateTransport;

public class LeagueCreateMapper {

    public static League toLeague(LeagueCreateTransport leagueCreateTransport) {
        return League.builder()
                .name(leagueCreateTransport.getName())
                .build();
    }
}

