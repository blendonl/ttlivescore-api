package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.entity.MatchPlayer;
import com.pek.ttlivescoreapi.match.repository.MatchPlayerRepository;
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
