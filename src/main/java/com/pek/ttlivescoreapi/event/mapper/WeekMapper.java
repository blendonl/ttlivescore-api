package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Week;
import com.pek.ttlivescoreapi.event.transport.WeekTransport;
import com.pek.ttlivescoreapi.league.mapper.LeagueMapper;

public class WeekMapper {

    public static WeekTransport toWeekTransport(Week week) {
        return WeekTransport.builder()
                .date(week.getEvent().getDate())
                .name(week.getEvent().getName())
                .leagueTransport(LeagueMapper.toLeagueTransport(week.getLeague()))
                .build();
    }
}
