package com.pek.ttlivescoreapi.event.controller;

import com.pek.ttlivescoreapi.event.service.TournamentService;
import com.pek.ttlivescoreapi.event.transport.TournamentCreateTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("events/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }


    @PostMapping()
    public TournamentShortTransport save(@RequestBody TournamentCreateTransport tournament) {
        return this.tournamentService.save(tournament);
    }


}
