package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserUpdateTransport;

public class UserUpdateMapper {

    public static User toUser(UserUpdateTransport user) {
        return User.builder()
                .name(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();

    }
}
