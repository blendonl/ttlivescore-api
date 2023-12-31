package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;

import java.util.List;

public class MatchMapper {

    public static MatchTransport toMatchTransport(Match match) {
        return MatchTransport.builder()
                .id(match.getId())
                .players(match.getPlayers().stream().map(GroupMapper::toGroupTransport).toList())
                .isDouble(match.isDouble())
                .isFinished(match.isFinished())
                .referee(match.getReferee() != null ? UserMapper.mapToUserTransport(match.getReferee()) : null)
                .build();
    }

    public static Match toMatch(MatchTransport matchTransport) {
        return Match.builder()
                .id(matchTransport.getId())
//                .players(matchTransport.getPlayers().stream().map(m -> Group.builder().player1()))
                .referee(UserMapper.mapToUser(matchTransport.getReferee()))
                .isDouble(matchTransport.isDouble())
                .isFinished(matchTransport.isFinished())
                .build();
    }

    public static List<MatchTransport> toMatchTransports(List<Match> matches) {
        return matches.stream().map(MatchMapper::toMatchTransport).toList();
    }
}
