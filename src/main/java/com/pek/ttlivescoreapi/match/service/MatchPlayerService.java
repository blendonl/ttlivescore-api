package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchPlayerService {

    List<MatchPlayerTransport> findAllByMatchId(long matchId);


}
