package com.pek.ttlivescoreapi.match.controller;


import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("match")
public class MatchController {

    private MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("")
    public MatchTransport save(@RequestBody MatchTransport matchTransport) {
        return service.save(matchTransport);
    }

    @PatchMapping( )
    public MatchTransport update(@RequestBody MatchTransport matchTransport) {
        return service.update(matchTransport);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }


    @GetMapping("{matchId}")
    public MatchTransport getMatchById(@PathVariable long matchId) {
        return service.findById(matchId);
    }


    @GetMapping("/{singleMatchId}/{playerId}")
    public int getPlayerPointsInASingleMatch(@PathVariable long singleMatchId, @PathVariable long playerId) {
//        return service.getPlayersPointInASingleMatch(singleMatchId, playerId);
        return 0;
    }

    @GetMapping("/{singleMatchId}/winner")
    public UserTransport getWinnerInASingleMatch(@PathVariable long singleMatchId) {

        UserTransport user = (service.getWinnerInASingleMatch(singleMatchId));

        return user;
    }

    @GetMapping("find/{player1Id}/{player2Id}")
    public List<Match> getSingleMatchesByPlayer1IdAndPlayer2Id(@PathVariable long player1Id, @PathVariable long player2Id) {
//        return service.findSingleMatchByPlayer1IdAndPlayer2Id(player1Id, player2Id);

        return null;
    }
}
