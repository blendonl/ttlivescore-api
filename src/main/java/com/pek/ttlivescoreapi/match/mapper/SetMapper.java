package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.entity.Set;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.match.transport.SetTransport;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;

import java.util.List;

public class SetMapper {

    public static SetTransport toSetTransport(Set set) {
        return SetTransport.builder()
                .match(MatchMapper.toMatchTransport(set.getMatch()))
                .points(PointMapper.toPointsTransport(set.getPoints()))
                .id(set.getId())
                .build();
    }

    public static Set toSet(SetTransport setTransport) {

        return Set.builder()
                .match(MatchMapper.toMatch(setTransport.getMatch()))
                .points(PointMapper.toPoints(setTransport.getPoints()))
                .id(setTransport.getId())
                .build();
    }

    public static List<SetTransport> toSetsTransport(List<Set> sets) {
        return sets.stream().map(SetMapper::toSetTransport).toList();
    }
}
