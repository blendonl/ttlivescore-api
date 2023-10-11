package com.pek.ttlivescoreapi.match.service;

import org.springframework.stereotype.Service;


@Service
public interface PointService {
    int findAllByMatchIdAndPlayerId(long matchId, long playerId);
}
