package com.pek.ttlivescoreapi.event.controller;

import com.pek.ttlivescoreapi.event.service.TournamentService;
import com.pek.ttlivescoreapi.event.transport.*;
import com.pek.ttlivescoreapi.match.transport.MatchShortTransport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping("{tournamentId}")
    public TournamentShortTransport save(@PathVariable long tournamentId, @RequestBody TournamentUpdateTransport tournament) {
        return this.tournamentService.update(tournamentId, tournament);
    }

    @GetMapping()
    public List<TournamentShortTransport> getAll(TournamentQueryTransport query) {
        return this.tournamentService.findAll(query);
    }

    @GetMapping("{tournamentId}")
    public TournamentTransport getOne(@PathVariable long tournamentId) {
        return this.tournamentService.findById(tournamentId);
    }

    @GetMapping("{tournamentId}/matches")
    public List<MatchShortTransport> getTournamentMatches(@PathVariable long tournamentId) {
        return this.tournamentService.findAllTournamentMatches(tournamentId);
    }

    @DeleteMapping("{tournamentId}")
    public void deleteById(@PathVariable long tournamentId) {
        this.tournamentService.deleteById(tournamentId);
    }


}
