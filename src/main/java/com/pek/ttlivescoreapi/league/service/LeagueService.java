package com.pek.ttlivescoreapi.league.service;


import com.pek.ttlivescoreapi.league.transport.LeagueTransport;

import java.util.List;

public interface LeagueService {

    LeagueTransport save(LeagueTransport leagueDto);
    List<LeagueTransport> findAll();
    void deleteById(long id);

    LeagueTransport findById(long id);
}
