package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.entity.MatchPlayer;
import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.transport.UserTransport;

import java.util.List;

public class MatchPlayerMapper {

    public static MatchPlayerTransport toMatchPlayerTransport(MatchPlayer matchPlayer) {
        return MatchPlayerTransport.builder()
                .player(UserMapper.mapToUserTransport(matchPlayer.getPlayer()))
                .matchId(matchPlayer.getMatch().getId())
                .build();
    }

    public static MatchPlayer toMatchPlayer(MatchPlayerTransport matchPlayer) {
        return MatchPlayer.builder()
                .player(UserMapper.mapToUser(matchPlayer.getPlayer()))
                .match(new Match(matchPlayer.getMatchId()))
                .doubles(matchPlayer.isDouble())
                .side(matchPlayer.isSide())
                .build();
    }
    public static List<MatchPlayerTransport> toMatchPlayerTransports(List<MatchPlayer> matchPlayers) {
        return matchPlayers.stream().map(MatchPlayerMapper::toMatchPlayerTransport).toList();
    }

    public static List<MatchPlayer> toMatchPlayers(List<MatchPlayerTransport> matchPlayers) {
        return matchPlayers.stream().map(MatchPlayerMapper::toMatchPlayer).toList();
    }
}
