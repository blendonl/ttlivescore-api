package com.pek.ttlivescoreapi.team.mapper;


import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.tansport.TeamTransport;
import com.pek.ttlivescoreapi.user.mapper.UserShortMapper;

import java.util.List;

public class TeamMapper {

    public static List<TeamTransport> mapToTeamsTransport(List<Team> team) {
        return team.stream().map(TeamMapper::mapToTeamTransport).toList();
    }

    public static TeamTransport mapToTeamTransport(Team team) {
        return TeamTransport
                .builder()
                .name(team.getName())
                .leagueName(team.getLeague() != null ? team.getLeague().getName() : "")
                .users(team.getUsers().stream().map(UserShortMapper::mapToUserShortTransport).toList())
                .build();
    }

    public static Team mapToTeam(TeamTransport teamTransport) {
        return Team
                .builder()
                .name(teamTransport.getName())
                .league(League.builder().name(teamTransport.getLeagueName()).build()).build();
    }
}
