package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserShortTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import lombok.SneakyThrows;

import java.util.List;

public class UserShortMapper {

    @SneakyThrows
    public static UserShortTransport mapToUserShortTransport(User user) {

        return UserShortTransport.builder()
                .id(user.getId().toString())
                .firstName(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .gender(user.getGender())
                .build();
    }

    public static List<UserShortTransport> mapToUserShortsTransport(List<User> users) {
        return users.stream().map(UserShortMapper::mapToUserShortTransport).toList();
    }
}
