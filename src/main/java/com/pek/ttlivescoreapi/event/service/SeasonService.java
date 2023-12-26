package com.pek.ttlivescoreapi.event.service;

import com.pek.ttlivescoreapi.event.transport.SeasonTransport;

import java.util.List;

public interface SeasonService {


    SeasonTransport findById(long id);

    SeasonTransport update(SeasonTransport season);

    SeasonTransport save(SeasonTransport season);

    List<SeasonTransport> findAllByLeagueId(long leagueId);

    List<SeasonTransport> finAllByLeagueIdAndYear(long leagueId, int year);


}
