package com.pek.ttlivescoreapi.league.controller;

import com.pek.ttlivescoreapi.league.service.LeagueService;
import com.pek.ttlivescoreapi.league.transport.LeagueQueryTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueShortTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("leagues")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("{id}")
    public LeagueTransport getOne(@PathVariable long id) {
        return leagueService.findById(id);
    }

    @GetMapping("")
    public List<LeagueShortTransport> getAll(LeagueQueryTransport query) {
        return leagueService.findAll(query);
    }
}
