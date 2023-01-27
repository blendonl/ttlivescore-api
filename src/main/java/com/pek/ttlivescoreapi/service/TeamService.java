package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.config.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.entity.Team;
import com.pek.ttlivescoreapi.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository repository;

    public TeamService(TeamRepository repository) {
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
