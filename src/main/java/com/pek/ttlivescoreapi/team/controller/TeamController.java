package com.pek.ttlivescoreapi.team.controller;

import com.pek.ttlivescoreapi.team.dto.TeamDto;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.mapper.TeamMapper;
import com.pek.ttlivescoreapi.team.service.TeamService;
import com.pek.ttlivescoreapi.user.dto.UserDto;
import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamController {

    private TeamService teamService;
    private UserService userService;


    public TeamController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public TeamDto findByTeamName(@PathVariable String name) throws TeamNotFoundException {
        Team team = teamService.findByName(name);

        return TeamMapper.mapTeamToTeamDto(team);

    }

    @PostMapping("")
    public TeamDto save(@RequestBody TeamDto teamDto) {
        Team team = TeamMapper.mapTeamDtoToTeam(teamDto);

        return TeamMapper.mapTeamToTeamDto(teamService.save(team));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) throws TeamNotFoundException {
        teamService.deleteById(id);
    }

    @GetMapping("{teamName}/players")
    public List<UserDto> findAllPlayerByTeamName(@PathVariable String teamName) {
        return userService.findAllByTeamName(teamName);
    }


}
