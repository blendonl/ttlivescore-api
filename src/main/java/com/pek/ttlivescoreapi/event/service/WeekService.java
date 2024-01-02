package com.pek.ttlivescoreapi.event.service;

import com.pek.ttlivescoreapi.event.transport.WeekCreateTransport;
import com.pek.ttlivescoreapi.event.transport.WeekShortTransport;
import com.pek.ttlivescoreapi.event.transport.WeekTransport;

import java.util.List;

public interface WeekService {


    WeekTransport findById(long id);

    List<WeekShortTransport> findAll();

    WeekTransport update(WeekTransport week);

    WeekShortTransport save(WeekCreateTransport newWeek);

    List<WeekShortTransport> findAllByLeagueId(long leagueId);

    List<WeekShortTransport> finAllByLeagueIdAndYear(long leagueId, int year);


}
