package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.entity.MatchPlayer;
import com.pek.ttlivescoreapi.repository.MatchPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchPlayerService {

    private MatchPlayerRepository matchPlayerRepository;


    public MatchPlayerService(MatchPlayerRepository matchPlayerRepository) {
        this.matchPlayerRepository = matchPlayerRepository;
    }

    public List<MatchPlayer> findAllByMatchId(long matchId) {
        return matchPlayerRepository.findAllByMatchId(matchId);
    }
}
