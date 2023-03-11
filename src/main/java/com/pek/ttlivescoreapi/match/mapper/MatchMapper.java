package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;

import java.util.List;

public class MatchMapper {

    public static MatchTransport toMatchTransport(Match match) {
        return new MatchTransport();
    }

    public static Match toMatch(MatchTransport matchTransport) {
        return new Match();
    }

    public static List<MatchTransport> toMatchTransports(List<Match> matches) {
        return matches.stream().map(MatchMapper::toMatchTransport).toList();
    }
}
