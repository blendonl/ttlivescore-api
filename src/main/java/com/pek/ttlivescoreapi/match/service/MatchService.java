package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.user.transport.UserTransport;
import org.springframework.stereotype.Service;


@Service
public interface MatchService {
    UserTransport getWinnerInASingleMatch(long singleMatchId);

}
