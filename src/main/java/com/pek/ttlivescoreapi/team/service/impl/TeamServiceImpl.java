package com.pek.ttlivescoreapi.team.service.impl;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.mapper.TeamMapper;
import com.pek.ttlivescoreapi.team.mapper.TeamShortMapper;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import com.pek.ttlivescoreapi.team.service.TeamService;
import com.pek.ttlivescoreapi.team.tansport.TeamQueryTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamShortTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    public TeamTransport findById(long id) throws TeamNotFoundException {
        Team team = repository.findById(id).orElseThrow(TeamNotFoundException::new);

        return TeamMapper.mapToTeamTransport(team);
    }

    public TeamTransport findByName(String name) throws TeamNotFoundException {
        Team team = repository.findByName(name).orElseThrow(TeamNotFoundException::new);

        return TeamMapper.mapToTeamTransport(team);
    }

    public TeamTransport save(Team team) {
        return TeamMapper.mapToTeamTransport(repository.save(team));
    }

    public void deleteById(long id) throws TeamNotFoundException {
        if (!repository.existsById(id)) {
            throw new TeamNotFoundException();
        }

        repository.deleteById(id);
    }


    public List<TeamTransport> findAllByLeagueId(long leagueId) {
        return TeamMapper.mapToTeamsTransport(repository.findAllByLeagueId(leagueId));
    }

    @Override
    public List<TeamShortTransport> findAll(TeamQueryTransport query) {
        return TeamShortMapper.toTeamsShort(repository.findAllByQuery(query));

    }
}
