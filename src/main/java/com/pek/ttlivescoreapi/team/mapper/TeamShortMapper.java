package com.pek.ttlivescoreapi.team.mapper;


import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.tansport.TeamShortTransport;

import java.util.List;

public class TeamShortMapper {

    public static TeamShortTransport toTeamShort(Team team) {
        return TeamShortTransport.builder()
                .id(team.getId().toString())
                .leagueName(team.getLeague() != null ? team.getLeague().getName() : "")
                .name(team.getName())
                .build();
    }

    public static List<TeamShortTransport> toTeamsShort(List<Team> teams) {
        return teams.stream().map(TeamShortMapper::toTeamShort).toList();
    }
}
