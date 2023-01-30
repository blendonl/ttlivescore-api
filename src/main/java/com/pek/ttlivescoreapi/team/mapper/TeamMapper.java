package com.pek.ttlivescoreapi.team.mapper;


import com.pek.ttlivescoreapi.team.dto.TeamDto;
import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.team.Team;

import java.util.List;

public class TeamMapper {

    public static TeamDto mapTeamToTeamDto(Team team) {
        return TeamDto
                .builder()
                .name(team.getName())
                .leagueName(team.getLeague().getName())
                .build();
    }

    public static List<TeamDto> mapTeamsToTeamsDto(List<Team> team) {
        return team.stream().map(TeamMapper::mapTeamToTeamDto).toList();
    }


    public static Team mapTeamDtoToTeam(TeamDto team) {
        return Team
                .builder()
                .name(team.getName())
                .league(League.builder().name(team.getLeagueName()).build()).build();
    }
}
