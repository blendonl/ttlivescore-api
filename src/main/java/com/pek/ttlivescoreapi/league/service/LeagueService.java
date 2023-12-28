package com.pek.ttlivescoreapi.league.service;


import com.pek.ttlivescoreapi.league.transport.*;

import java.util.List;

public interface LeagueService {

    LeagueShortTransport save(LeagueCreateTransport newLeague);

    List<LeagueShortTransport> findAll(LeagueQueryTransport query);

    void deleteById(long id);

    LeagueTransport findById(long id);

    LeagueShortTransport update(long id, LeagueUpdateTransport league);


}

