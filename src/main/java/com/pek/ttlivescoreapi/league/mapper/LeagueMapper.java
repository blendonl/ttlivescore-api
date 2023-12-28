package com.pek.ttlivescoreapi.league.mapper;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;
import com.pek.ttlivescoreapi.team.mapper.TeamShortMapper;

import java.util.ArrayList;
import java.util.List;

public class LeagueMapper {

    public static LeagueTransport toLeagueDto(League league) {
        return LeagueTransport.builder()
                .id(league.getId())
                .name(league.getName())
                .teams(league.getTeams() != null ? TeamShortMapper.toTeamsShort(league.getTeams()) : new ArrayList<>())
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
