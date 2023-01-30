package com.pek.ttlivescoreapi.team.service.impl;

import com.pek.ttlivescoreapi.team.dto.TeamDto;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.mapper.TeamMapper;
import com.pek.ttlivescoreapi.team.service.TeamService;
import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;

import java.util.List;

public class TeamServiceImpl implements TeamService {

    private TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    public TeamDto findById(long id) throws TeamNotFoundException {
        Team team = repository.findById(id).orElseThrow(TeamNotFoundException::new);

        return TeamMapper.mapTeamToTeamDto(team);
    }

    public TeamDto findByName(String name) throws TeamNotFoundException {
        Team team = repository.findByName(name).orElseThrow(TeamNotFoundException::new);

        return TeamMapper.mapTeamToTeamDto(team);
    }

    public TeamDto save(Team team) {
        return TeamMapper.mapTeamToTeamDto(repository.save(team));
    }

    public void deleteById(long id) throws TeamNotFoundException {
        if(!repository.existsById(id)) {
            throw new TeamNotFoundException();
        }

        repository.deleteById(id);
    }




    public List<TeamDto> findAllByLeagueId(long leagueId) {
        return TeamMapper.mapTeamsToTeamsDto(repository.findAllByLeagueId(leagueId));
    }
}
