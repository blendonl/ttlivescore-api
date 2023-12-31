package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Group;
import com.pek.ttlivescoreapi.match.transport.GroupTransport;
import com.pek.ttlivescoreapi.user.mapper.UserShortMapper;

public class GroupMapper {

    public static GroupTransport toGroupTransport(Group group) {

        return GroupTransport.builder()
                .player1(UserShortMapper.mapToUserShortTransport(group.getPlayer1()))
                .player2(UserShortMapper.mapToUserShortTransport(group.getPlayer2()))
                .build();

    }
}
