package com.pek.ttlivescoreapi.mapper;


import com.pek.ttlivescoreapi.dto.TeamDto;
import com.pek.ttlivescoreapi.entity.Team;

import java.util.List;

public class TeamDtoMapper {

    public static TeamDto mapToTeamDto(Team team) {
        return TeamDto
                .builder()
                .name(team.getName())
                .leagueName(team.getLeague().getName())
                .build();
    }

    public static List<TeamDto> mapToTeamsDto(List<Team> team) {
        return team.stream().map(TeamDtoMapper::mapToTeamDto).toList();
    }
}
