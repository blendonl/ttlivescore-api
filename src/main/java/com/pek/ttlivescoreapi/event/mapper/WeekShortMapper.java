package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Week;
import com.pek.ttlivescoreapi.event.transport.WeekShortTransport;

import java.util.List;

public class WeekShortMapper {

    public static List<WeekShortTransport> toWeekShortsTransport(List<Week> weeks) {
        return weeks.stream().map(WeekShortMapper::toWeekShortTransport).toList();

    }

    public static WeekShortTransport toWeekShortTransport(Week week) {

        return WeekShortTransport.builder()
                .id(week.getId())
                .name(week.getEvent().getName())
                .league(week.getLeague().getName())
                .build();

    }
}
