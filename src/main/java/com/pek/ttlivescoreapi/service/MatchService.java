package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.entity.Match;
import com.pek.ttlivescoreapi.entity.MatchPlayer;
import com.pek.ttlivescoreapi.entity.User;
import com.pek.ttlivescoreapi.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {


    private MatchRepository matchRepository;
    private MatchPlayerService matchPlayerService;
    private PointService pointService;

    public MatchService(MatchRepository matchRepository, MatchPlayerService matchPlayerService, PointService pointService) {
        this.matchRepository = matchRepository;
        this.matchPlayerService = matchPlayerService;
        this.pointService = pointService;
    }

    public User getWinnerInASingleMatch(long singleMatchId) {

        List<MatchPlayer> players = matchPlayerService.findAllByMatchId(singleMatchId);

        int player1Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(0).getId()).size();
        int player2Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(1).getId()).size();

        if(player1Points > player2Points) {
            return players.get(0).getPlayer();
        }

        return players.get(1).getPlayer();


    }

}
