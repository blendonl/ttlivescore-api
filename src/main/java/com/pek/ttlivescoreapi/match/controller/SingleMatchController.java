package com.pek.ttlivescoreapi.match.controller;


import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.match.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("singleMatch")
public class SingleMatchController {

    private MatchService service;

    public SingleMatchController(MatchService service) {
        this.service = service;
    }


    @GetMapping("/{singleMatchId}/{playerId}")
    public int getPlayerPointsInASingleMatch(@PathVariable long singleMatchId, @PathVariable long playerId) {
//        return service.getPlayersPointInASingleMatch(singleMatchId, playerId);
        return 0;
    }

    @GetMapping("/{singleMatchId}/winner")
    public UserTransport getWinnerInASingleMatch(@PathVariable long singleMatchId) {

        UserTransport user = UserMapper.mapToUserTransport(service.getWinnerInASingleMatch(singleMatchId));

        return user;
    }

    @GetMapping("find/{player1Id}/{player2Id}")
    public List<Match> getSingleMatchesByPlayer1IdAndPlayer2Id(@PathVariable long player1Id, @PathVariable long player2Id) {
//        return service.findSingleMatchByPlayer1IdAndPlayer2Id(player1Id, player2Id);

        return null;
    }
}
