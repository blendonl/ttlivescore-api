package com.pek.ttlivescoreapi.controller;


import com.pek.ttlivescoreapi.user.dto.UserDto;
import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.user.mapper.UserDtoMapper;
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
    public UserDto getWinnerInASingleMatch(@PathVariable long singleMatchId) {

        UserDto user = UserDtoMapper.userToUserDto(service.getWinnerInASingleMatch(singleMatchId));

        return user;
    }

    @GetMapping("find/{player1Id}/{player2Id}")
    public List<Match> getSingleMatchesByPlayer1IdAndPlayer2Id(@PathVariable long player1Id, @PathVariable long player2Id) {
//        return service.findSingleMatchByPlayer1IdAndPlayer2Id(player1Id, player2Id);

        return null;
    }
}
