package com.pek.ttlivescoreapi.controller;

import com.pek.ttlivescoreapi.config.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.dto.TeamDto;
import com.pek.ttlivescoreapi.entity.Team;
import com.pek.ttlivescoreapi.mapper.TeamDtoMapper;
import com.pek.ttlivescoreapi.service.TeamService;
import com.pek.ttlivescoreapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return TeamDtoMapper.mapToTeamDto(team);

    }
}
