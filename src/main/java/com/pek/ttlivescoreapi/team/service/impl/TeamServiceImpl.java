package com.pek.ttlivescoreapi.team.service.impl;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.exception.TeamAlreadyExistException;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.mapper.TeamCreateMapper;
import com.pek.ttlivescoreapi.team.mapper.TeamMapper;
import com.pek.ttlivescoreapi.team.mapper.TeamShortMapper;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import com.pek.ttlivescoreapi.team.service.TeamService;
import com.pek.ttlivescoreapi.team.tansport.*;
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

    public TeamShortTransport save(TeamCreateTransport newTeam) throws TeamAlreadyExistException {
        if (this.repository.findByName(newTeam.getName()).orElse(null) != null) {
            throw new TeamAlreadyExistException("team already exist");
        }

        Team team = TeamCreateMapper.toTeam(newTeam);

        return TeamShortMapper.toTeamShort(repository.save(team));
    }

    @Override
    public TeamShortTransport update(long id, TeamUpdateTransport newTeam) throws TeamNotFoundException, TeamAlreadyExistException {

        Team team = this.repository.findById(id).orElseThrow(TeamNotFoundException::new);

        if (this.repository.findByName(newTeam.getName()).orElse(null) != null) {
            throw new TeamAlreadyExistException("team with that name already exist");
        }

        team.setName(newTeam.getName());

        return TeamShortMapper.toTeamShort(repository.save(team));
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
