package com.pek.ttlivescoreapi.league.mapper;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.dto.LeagueDto;

import java.util.List;

public class LeagueMapper {

    public static LeagueDto toLeagueDto(League league) {
       return LeagueDto.builder()
               .name(league.getName())
               .build();
    }

    public static League toLeague(LeagueDto leagueDto) {
        return League
                .builder()
                .name(leagueDto.getName())
                .build();
    }

    public static List<LeagueDto> toLeaguesDto(List<League> leagues) {
        return leagues.stream().map(LeagueMapper::toLeagueDto).toList();
    }
}
