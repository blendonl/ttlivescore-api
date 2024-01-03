package com.pek.ttlivescoreapi.team.mapper;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.tansport.TeamCreateTransport;

public class TeamCreateMapper {

    public static Team toTeam(TeamCreateTransport newTeam) {
        return Team.builder()
                .name(newTeam.getName())
                .build();
    }
}
