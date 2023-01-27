package com.pek.ttlivescoreapi.mapper;


import com.pek.ttlivescoreapi.dto.TeamDto;
import com.pek.ttlivescoreapi.entity.League;
import com.pek.ttlivescoreapi.entity.Team;

import java.util.List;

public class TeamDtoMapper {

    public static TeamDto mapTeamToTeamDto(Team team) {
        return TeamDto
                .builder()
                .name(team.getName())
                .leagueName(team.getLeague().getName())
                .build();
    }

    public static List<TeamDto> mapTeamsToTeamsDto(List<Team> team) {
        return team.stream().map(TeamDtoMapper::mapTeamToTeamDto).toList();
    }


    public static Team mapTeamDtoToTeam(TeamDto team) {
        return Team
                .builder()
                .name(team.getName())
                .league(League.builder().name(team.getLeagueName()).build()).build();
    }
}
