package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserTransport;


public interface MatchService {
    UserTransport getWinnerInASingleMatch(long singleMatchId);

}
