package com.pek.ttlivescoreapi.league.controller;

import com.pek.ttlivescoreapi.league.service.LeagueService;
import com.pek.ttlivescoreapi.league.transport.*;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public LeagueShortTransport create(@RequestBody LeagueCreateTransport league) {
        return leagueService.save(league);
    }

    @PatchMapping("{id}")
    public LeagueShortTransport update(@PathVariable long id, @RequestBody LeagueUpdateTransport league) {
        return leagueService.update(id, league);
    }
}
