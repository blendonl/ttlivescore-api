package com.pek.ttlivescoreapi.team.service;

import com.pek.ttlivescoreapi.team.exception.TeamAlreadyExistException;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.tansport.*;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.transport.UserShortTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    TeamTransport findById(long id) throws TeamNotFoundException;

    TeamTransport findByName(String name) throws TeamNotFoundException;

    TeamShortTransport save(TeamCreateTransport newTeam) throws TeamAlreadyExistException;

    TeamShortTransport update(long id, TeamUpdateTransport team) throws TeamAlreadyExistException, TeamNotFoundException;

    void deleteById(long id) throws TeamNotFoundException;

    List<TeamTransport> findAllByLeagueId(long leagueId);

    List<TeamShortTransport> findAll(TeamQueryTransport query);

    TeamShortTransport addPlayer(long id, AddUserToTeamTransport user) throws TeamNotFoundException, UserNotFoundException;

    TeamShortTransport removePlayer(long teamId, long playerId) throws UserNotFoundException, TeamNotFoundException;

    List<UserShortTransport> findAllPayers(long teamId) throws TeamNotFoundException;


}
