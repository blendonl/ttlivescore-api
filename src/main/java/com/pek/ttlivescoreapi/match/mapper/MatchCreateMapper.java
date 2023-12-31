package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.transport.MatchCreateTransport;

public class MatchCreateMapper {

    public static Match toMatch(MatchCreateTransport match) {
        return Match.builder()
                .players(match.getPlayers().stream().map(GroupShortMapper::toGroup).toList())
                .build();
    }
}
