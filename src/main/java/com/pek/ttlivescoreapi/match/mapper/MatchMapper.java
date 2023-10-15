package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.transport.UserTransport;

import java.util.List;

public class MatchMapper {

    public static MatchTransport toMatchTransport(Match match) {
        return MatchTransport.builder()
                .id(match.getId())
//                .players(match.getMatchPlayers().stream().map(mp -> mp.getPlayer().getEmail()).toList())
                .isFinished(match.isFinished())
//                .referee(UserMapper.mapToUserTransport(match.getReferee()))
                .build();
    }

    public static Match toMatch(MatchTransport matchTransport) {

        return Match.builder()
                .id(matchTransport.getId())
//                .finished(matchTransport.isFinished())
                .referee(UserMapper.mapToUser(matchTransport.getReferee()))
                .build();
    }

    public static List<MatchTransport> toMatchTransports(List<Match> matches) {
        return matches.stream().map(MatchMapper::toMatchTransport).toList();
    }
}
