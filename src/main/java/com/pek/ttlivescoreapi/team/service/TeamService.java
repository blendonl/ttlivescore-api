package com.pek.ttlivescoreapi.team.service;

import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    Team findById(long id) throws TeamNotFoundException;

    Team findByName(String name) throws TeamNotFoundException;

    Team save(Team team);

    void deleteById(long id) throws TeamNotFoundException;

    List<Team> findAllByLeagueId(long leagueId);
}
