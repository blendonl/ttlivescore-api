package com.pek.ttlivescoreapi.event.service;

import com.pek.ttlivescoreapi.event.transport.WeekCreateTransport;
import com.pek.ttlivescoreapi.event.transport.WeekShortTransport;
import com.pek.ttlivescoreapi.event.transport.WeekTransport;
import com.pek.ttlivescoreapi.event.transport.WeekUpdateTransport;

import java.util.List;

public interface WeekService {


    WeekTransport findById(long id);

    List<WeekShortTransport> findAll();

    WeekShortTransport update(long id, WeekUpdateTransport newWeek);

    WeekShortTransport save(WeekCreateTransport newWeek);

    void deleteById(Long weekId);

    List<WeekShortTransport> findAllByLeagueIdAndYear(long leagueId, long year);


}
