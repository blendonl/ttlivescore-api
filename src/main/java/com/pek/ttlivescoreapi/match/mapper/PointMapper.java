package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.match.transport.PointTransport;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.transport.UserTransport;

import java.util.List;

public class PointMapper {

    public static PointTransport toPointTransport(Point point) {
        return PointTransport
                .builder()
                .id(point.getId())
                .player(UserMapper.mapToUserTransport(point.getPlayer()))
                .match(MatchMapper.toMatchTransport(point.getMatch()))
        .build();
    }

    public static Match toMatch(MatchTransport matchTransport) {
        return new Match();
    }

    public static List<PointTransport> toPointsTransport(List<Point> points) {
        return points.stream().map(PointMapper::toPointTransport).toList();
    }

    public static Point toPoint(PointTransport pointTransport) {
        return Point
                .builder()
                .id(pointTransport.getId())
                .player(UserMapper.mapToUser(pointTransport.getPlayer()))
                .match(MatchMapper.toMatch(pointTransport.getMatch()))
                .build();
    }
}
