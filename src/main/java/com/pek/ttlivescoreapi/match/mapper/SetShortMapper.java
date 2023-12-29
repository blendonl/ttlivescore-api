package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.match.entity.Set;
import com.pek.ttlivescoreapi.match.transport.SetShortTransport;

import java.util.List;

public class SetShortMapper {

    public static SetShortTransport toSetShortTransport(Set set) {
        return SetShortTransport.builder()
                .isFinished(set.isFinished())
                .teamAPoints(set.getPoints().stream().filter(Point::isTeamA).count())
                .teamBPoints(set.getPoints().stream().filter(p -> !p.isTeamA()).count())
                .build();

    }

    public static List<SetShortTransport> toSetShortTransport(List<Set> sets) {
        return sets.stream().map(SetShortMapper::toSetShortTransport).toList();
    }
}
