package com.pek.ttlivescoreapi.team.service;

import com.pek.ttlivescoreapi.team.tansport.TeamTransport;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    TeamTransport findById(long id) throws TeamNotFoundException;

    TeamTransport findByName(String name) throws TeamNotFoundException;

    TeamTransport save(Team team);

    void deleteById(long id) throws TeamNotFoundException;

    List<TeamTransport> findAllByLeagueId(long leagueId);
}
