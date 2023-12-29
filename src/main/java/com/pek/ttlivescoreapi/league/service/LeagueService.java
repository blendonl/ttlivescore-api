package com.pek.ttlivescoreapi.league.service;


import com.pek.ttlivescoreapi.league.transport.*;
import com.pek.ttlivescoreapi.team.tansport.TeamShortTransport;

import java.util.List;

public interface LeagueService {

    LeagueShortTransport save(LeagueCreateTransport newLeague);

    List<LeagueShortTransport> findAll(LeagueQueryTransport query);

    void deleteById(long id);

    LeagueTransport findById(long id);

    LeagueShortTransport update(long id, LeagueUpdateTransport league);

    List<TeamShortTransport> findAllTeams(long leagueId);

    TeamShortTransport findOneTeamById(long leagueId, long teamId);

    TeamShortTransport addTeam(long leagueId, AddTeamToLeagueTransport team);

    TeamShortTransport removeTeam(long leagueId, long teamId);


}

