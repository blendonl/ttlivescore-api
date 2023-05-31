package com.pek.ttlivescoreapi.match.controller;


import com.pek.ttlivescoreapi.match.service.MatchPlayerService;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.match.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("match")
public class MatchController {

    private MatchService matchService;
    private MatchPlayerService matchPlayerService;

    public MatchController(MatchService service) {
        this.matchService = service;
    }

    @PostMapping("")
    public MatchTransport save(@RequestBody MatchTransport matchTransport) {
        return matchService.save(matchTransport);
    }

    @PatchMapping( )
    public MatchTransport update(@RequestBody MatchTransport matchTransport) {
        return matchService.update(matchTransport);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        matchService.deleteById(id);
    }


    @GetMapping("{matchId}")
    public MatchTransport getMatchById(@PathVariable long matchId) {
        return matchService.findById(matchId);
    }


    @GetMapping("/{singleMatchId}/{playerId}")
    public int getPlayerPointsInASingleMatch(@PathVariable long singleMatchId, @PathVariable long playerId) {
//        return service.getPlayersPointInASingleMatch(singleMatchId, playerId);
        return 0;
    }

    @GetMapping("/{singleMatchId}/winner")
    public UserTransport getWinnerInASingleMatch(@PathVariable long singleMatchId) {

        UserTransport user = (matchService.getWinnerInASingleMatch(singleMatchId));

        return user;
    }

    @GetMapping("single/{player1Id}/{player2Id}")
    public List<MatchTransport> getSingleMatchesByPlayer1IdAndPlayer2Id(@PathVariable long player1Id, @PathVariable long player2Id) {
        return matchService.findALlByPlayer1IdAndPlayer2Id(player1Id, player2Id);

    }
}
