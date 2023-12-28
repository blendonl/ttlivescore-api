package com.pek.ttlivescoreapi.league.service;


import com.pek.ttlivescoreapi.league.transport.LeagueCreateTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueQueryTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueShortTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;

import java.util.List;

public interface LeagueService {

    LeagueShortTransport save(LeagueCreateTransport newLeague);

    List<LeagueShortTransport> findAll(LeagueQueryTransport query);

    void deleteById(long id);

    LeagueTransport findById(long id);
}
