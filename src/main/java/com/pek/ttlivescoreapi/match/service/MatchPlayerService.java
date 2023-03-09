package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.entity.MatchPlayer;
import com.pek.ttlivescoreapi.event.repository.MatchPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchPlayerService {

    List<MatchPlayer> findAllByMatchId(long matchId);

}
