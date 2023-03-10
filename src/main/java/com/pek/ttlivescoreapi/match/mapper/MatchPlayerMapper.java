package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.MatchPlayer;
import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;

import java.util.List;

public class MatchPlayerMapper {

    public static MatchPlayerTransport toMatchPlayerTransport(MatchPlayer matchPlayer) {
        return new MatchPlayerTransport();
    }

    public static List<MatchPlayerTransport> toMatchPlayerTransports(List<MatchPlayer> matchPlayers) {
        return matchPlayers.stream().map(MatchPlayerMapper::toMatchPlayerTransport).toList();
    }
}
