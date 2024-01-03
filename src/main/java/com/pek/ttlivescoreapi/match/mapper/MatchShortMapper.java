package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.transport.MatchShortTransport;

import java.util.List;

public class MatchShortMapper {

    public static MatchShortTransport toMatchShortTransport(Match match) {
        return MatchShortTransport.builder()
                .id(match.getId())
                .isFinished(match.isFinished())
                .sets(match.getSets().stream().map(SetShortMapper::toSetShortTransport).toList())
                .build();
    }

    public static List<MatchShortTransport> toMatchShortsTransport(List<Match> matches) {
        return matches.stream().map(MatchShortMapper::toMatchShortTransport).toList();

    }
}
