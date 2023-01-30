package com.pek.ttlivescoreapi.controller;

import com.pek.ttlivescoreapi.dto.LeagueDto;
import com.pek.ttlivescoreapi.service.LeagueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("leagues")
public class LeagueController {

    private LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("{id}")
    public LeagueDto get(@PathVariable long id) {
        return leagueService.findById(id);
    }

}
