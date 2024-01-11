package com.pek.ttlivescoreapi.team.controller;

import com.pek.ttlivescoreapi.team.exception.TeamAlreadyExistException;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.service.TeamService;
import com.pek.ttlivescoreapi.team.tansport.*;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.service.UserService;
import com.pek.ttlivescoreapi.user.transport.UserShortTransport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamController {

    private final TeamService teamService;
    private final UserService userService;


    public TeamController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    @GetMapping("{id}")
    public TeamTransport findById(@PathVariable long id) throws TeamNotFoundException {
        return teamService.findById(id);
    }

    @GetMapping("")
    public List<TeamShortTransport> findAll(@RequestParam(required = false) TeamQueryTransport query) {
        return teamService.findAll(query);
    }

    @GetMapping("find/{name}")
    public TeamTransport findByTeamName(@PathVariable String name) throws TeamNotFoundException {
        return teamService.findByName(name);
    }

    @PostMapping("")
    public TeamShortTransport save(@RequestBody TeamCreateTransport team) throws TeamAlreadyExistException {
        return teamService.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) throws TeamNotFoundException {
        teamService.deleteById(id);
    }

//    @GetMapping("{teamName}/players")
//    public List<UserTransport> findAllPlayerByTeamName(@PathVariable String teamName) {
//        return userService.findAllByTeamName(teamName);
//    }

    @PatchMapping("{teamId}")
    public TeamShortTransport update(@PathVariable() long teamId, @RequestBody TeamUpdateTransport team) throws TeamNotFoundException, TeamAlreadyExistException {
        return this.teamService.update(teamId, team);
    }

    @PostMapping("{teamId}/players")
    public TeamShortTransport addPlayer(@PathVariable long teamId, @RequestBody AddUserToTeamTransport user) throws UserNotFoundException, TeamNotFoundException {
        return this.teamService.addPlayer(teamId, user);
    }

    @DeleteMapping("{teamId}/players/{playerId}")
    public TeamShortTransport addPlayer(@PathVariable long teamId, @PathVariable long playerId) throws UserNotFoundException, TeamNotFoundException {
        return this.teamService.removePlayer(teamId, playerId);
    }

    @GetMapping("{teamId}/players")
    public List<UserShortTransport> getAllPlayers(@PathVariable long teamId) throws TeamNotFoundException {
        return this.teamService.findAllPayers(teamId);
    }


}
