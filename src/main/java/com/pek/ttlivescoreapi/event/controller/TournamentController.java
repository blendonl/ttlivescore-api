package com.pek.ttlivescoreapi.event.controller;

import com.pek.ttlivescoreapi.event.service.TournamentService;
import com.pek.ttlivescoreapi.event.transport.TournamentCreateTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentUpdateTransport;
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
    public List<TournamentShortTransport> getAll() {
        return this.tournamentService.findAll();
    }

    @GetMapping("{tournamentId}")
    public TournamentTransport getOne(@PathVariable long tournamentId) {
        return this.tournamentService.findById(tournamentId);
    }

    @DeleteMapping("{tournamentId}")
    public void deleteById(@PathVariable long tournamentId) {
        this.tournamentService.deleteById(tournamentId);
    }


}
