package com.pek.ttlivescoreapi.team.service;

import com.pek.ttlivescoreapi.team.dto.TeamDto;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    TeamDto findById(long id) throws TeamNotFoundException;

    TeamDto findByName(String name) throws TeamNotFoundException;

    TeamDto save(Team team);

    void deleteById(long id) throws TeamNotFoundException;

    List<TeamDto> findAllByLeagueId(long leagueId);
}
