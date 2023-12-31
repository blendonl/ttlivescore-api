package com.pek.ttlivescoreapi.match.mapper;

import com.pek.ttlivescoreapi.match.entity.Group;
import com.pek.ttlivescoreapi.match.transport.GroupShortTransport;
import com.pek.ttlivescoreapi.user.entity.User;

import java.util.List;

public class GroupShortMapper {

    public static Group toGroup(GroupShortTransport group) {
        return Group.builder()
                .player1(User.builder().email(group.getPlayer1Email()).build())
                .player2(User.builder().email(group.getPlayer1Email()).build())
                .build();
    }

    public static List<Group> toGroups(List<GroupShortTransport> groups) {
        return groups.stream().map(GroupShortMapper::toGroup).toList();
    }
}
