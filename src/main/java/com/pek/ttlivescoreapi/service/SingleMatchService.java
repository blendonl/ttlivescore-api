package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.entity.SingleMatch;
import com.pek.ttlivescoreapi.entity.User;
import com.pek.ttlivescoreapi.repository.SingleMatchRepository;
import org.springframework.stereotype.Service;

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
        SingleMatch singleMatch = singleMatchRepository.findById(singleMatchId).orElse(null);


        int player1Points = getPlayersPointInASingleMatch(singleMatchId, singleMatch.getPlayer1().getId());
        int player2Points = getPlayersPointInASingleMatch(singleMatchId, singleMatch.getPlayer2().getId());

        if(player1Points > player2Points) {
            return singleMatch.getPlayer1();
        }

        return singleMatch.getPlayer2();

    }
}
