package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.user.entity.User;

import java.util.List;

public class UserMapper {

    public static UserTransport mapToUserTransport(User user) {
         return UserTransport.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .build();
    }

    public static List<UserTransport> mapToUsersTransport(List<User> users) {
        return users.stream().map(UserMapper::mapToUserTransport).toList();
    }


    public static User mapToUser(UserTransport userTransport) {
        return User.builder()
                .name(userTransport.getName())
                .lastName(userTransport.getLastName())
                .email(userTransport.getEmail())
                .password(userTransport.getPassword())
                .birthDate(userTransport.getBirthDate())
                .gender(userTransport.getGender())
                .build();
    }
}
