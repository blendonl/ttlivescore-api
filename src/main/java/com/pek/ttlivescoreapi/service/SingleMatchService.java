package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.entity.Match;
import com.pek.ttlivescoreapi.entity.User;
import com.pek.ttlivescoreapi.repository.SingleMatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingleMatchService {


    private SingleMatchRepository singleMatchRepository;

    public SingleMatchService(SingleMatchRepository singleMatchRepository) {
        this.singleMatchRepository = singleMatchRepository;
    }


    public int getPlayersPointInASingleMatch(long singleMatchId, long playerId) {
        return singleMatchRepository.getPlayerPointsSingleMatch(singleMatchId, playerId);
    }

    public User getWinnerInASingleMatch(long singleMatchId) {
//        Match singleMatch = singleMatchRepository.findById(singleMatchId).orElse(null);
//
//        int player1Points = getPlayersPointInASingleMatch(singleMatchId, singleMatch.getPlayer1().getId());
//        int player2Points = getPlayersPointInASingleMatch(singleMatchId, singleMatch.getPlayer2().getId());
//
//        if(player1Points > player2Points) {
//            return singleMatch.getPlayer1();
//        }
//
//        return singleMatch.getPlayer2();

        return null;

    }

    public List<Match> findSingleMatchByPlayer1IdAndPlayer2Id(long player1Id, long player2Id) {
//        return singleMatchleMatchRepository.findAllByPlayer1IdAndPlayer2Id(player1Id, player2Id);

        return null;
    }
}
