package com.pek.ttlivescoreapi.match.mapper;


import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.transport.MatchUpdateTransport;
import com.pek.ttlivescoreapi.user.entity.User;

public class MatchUpdateMapper {

    public static Match toMatch(MatchUpdateTransport match) {
        return Match.builder()
                .referee(User.builder().id(match.getRefereeId()).build())
                .build();

    }
}
