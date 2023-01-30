package com.pek.ttlivescoreapi.team.service.impl;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import com.pek.ttlivescoreapi.team.service.TeamService;

import java.util.List;

public class TeamServiceImpl implements TeamService {

    private TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    public Team findById(long id) throws TeamNotFoundException {
        return repository.findById(id).orElseThrow(TeamNotFoundException::new);
    }

    public Team findByName(String name) throws TeamNotFoundException {
        return repository.findByName(name).orElseThrow(TeamNotFoundException::new);
    }

    public Team save(Team team) {
        return repository.save(team);
    }

    public void deleteById(long id) throws TeamNotFoundException {
        if(!repository.existsById(id)) {
            throw new TeamNotFoundException();
        }

        repository.deleteById(id);
    }




    public List<Team> findAllByLeagueId(long leagueId) {
        return repository.findAllByLeagueId(leagueId);
    }
}
