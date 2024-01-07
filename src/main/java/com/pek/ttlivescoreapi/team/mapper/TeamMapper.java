package com.pek.ttlivescoreapi.team.mapper;


import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.tansport.TeamTransport;
import com.pek.ttlivescoreapi.user.mapper.UserShortMapper;

import java.util.ArrayList;
import java.util.List;

public class TeamMapper {

    public static List<TeamTransport> mapToTeamsTransport(List<Team> team) {
        return team.stream().map(TeamMapper::mapToTeamTransport).toList();
    }

    public static TeamTransport mapToTeamTransport(Team team) {
        return TeamTransport.builder()
                .id(team.getId())
                .name(team.getName())
                .leagues(team.getLeagues() != null ? TeamLeagueMapper.toTeamLeagueTransports(team.getLeagues()) : new ArrayList<>())
                .users(team.getUsers().stream().map(UserShortMapper::mapToUserShortTransport).toList())
                .build();
    }

}
