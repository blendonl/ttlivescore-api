package com.pek.ttlivescoreapi.team.service.impl;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.dto.TeamDto;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.mapper.TeamDtoMapper;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import com.pek.ttlivescoreapi.team.service.TeamService;

import java.util.List;

public class TeamServiceImpl implements TeamService {

    private TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    public TeamDto findById(long id) throws TeamNotFoundException {
        Team team = repository.findById(id).orElseThrow(TeamNotFoundException::new);

        return TeamDtoMapper.mapTeamToTeamDto(team);
    }

    public TeamDto findByName(String name) throws TeamNotFoundException {
        Team team = repository.findByName(name).orElseThrow(TeamNotFoundException::new);

        return TeamDtoMapper.mapTeamToTeamDto(team);
    }

    public TeamDto save(Team team) {
        return TeamDtoMapper.mapTeamToTeamDto(repository.save(team));
    }

    public void deleteById(long id) throws TeamNotFoundException {
        if(!repository.existsById(id)) {
            throw new TeamNotFoundException();
        }

        repository.deleteById(id);
    }




    public List<TeamDto> findAllByLeagueId(long leagueId) {
        return TeamDtoMapper.mapTeamsToTeamsDto(repository.findAllByLeagueId(leagueId));
    }
}
