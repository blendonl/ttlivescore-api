package com.pek.ttlivescoreapi.league.mapper;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;
import com.pek.ttlivescoreapi.team.mapper.TeamShortMapper;

import java.util.ArrayList;

public class LeagueMapper {

    public static LeagueTransport toLeagueTransport(League league) {
        return LeagueTransport.builder()
                .id(league.getId())
                .name(league.getName())
                .teams(league.getTeams() != null ? TeamShortMapper.toTeamsShort(league.getTeams()) : new ArrayList<>())
                .build();
    }

    public static League toLeague(LeagueTransport leagueTransport) {
        return League
                .builder()
                .name(leagueTransport.getName())
                .build();
    }

}
