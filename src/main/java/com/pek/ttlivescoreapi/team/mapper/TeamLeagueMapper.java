package com.pek.ttlivescoreapi.team.mapper;


import com.pek.ttlivescoreapi.team.entity.TeamLeague;
import com.pek.ttlivescoreapi.team.tansport.TeamLeagueTransport;

import java.util.List;

public class TeamLeagueMapper {

    public static List<TeamLeagueTransport> toTeamLeagueTransports(List<TeamLeague> teamLeagues) {
        return teamLeagues.stream().map(TeamLeagueMapper::toTeamLeagueTransport).toList();
    }

    public static TeamLeagueTransport toTeamLeagueTransport(TeamLeague teamLeague) {
        return TeamLeagueTransport.builder()
                .name(teamLeague.getLeague().getName())
                .year(teamLeague.getYear())
                .build();
    }

}
