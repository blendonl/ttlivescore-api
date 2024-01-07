package com.pek.ttlivescoreapi.league.mapper;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;
import com.pek.ttlivescoreapi.team.entity.TeamLeague;
import com.pek.ttlivescoreapi.team.mapper.TeamShortMapper;

import java.util.ArrayList;

public class LeagueMapper {

    public static LeagueTransport toLeagueTransport(League league) {
        return LeagueTransport.builder()
                .id(league.getId())
                .name(league.getName())
                .category(league.getCategory().name())
                .yearCreated(league.getYear())
                .teams(league.getTeams() != null ? TeamShortMapper.toTeamsShort(league.getTeams().stream().map(TeamLeague::getTeam).toList()) : new ArrayList<>())
                .build();
    }


}
