package com.pek.ttlivescoreapi.mapper;

import com.pek.ttlivescoreapi.dto.LeagueDto;
import com.pek.ttlivescoreapi.entity.League;

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
