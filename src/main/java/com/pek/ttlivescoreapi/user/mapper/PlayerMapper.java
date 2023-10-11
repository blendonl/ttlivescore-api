package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.PlayerTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;

import java.util.List;

public class PlayerMapper {
     public static PlayerTransport mapToPlayerTransport(User user, String teamName) {
         return PlayerTransport.builder()
                .firstName(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .gender(user.getGender())
                 .teamName(teamName)
                .build();
    }


    public static User mapToUser(PlayerTransport playerTransport) {
        return User.builder()
                .name(playerTransport.getFirstName())
                .lastName(playerTransport.getLastName())
                .email(playerTransport.getEmail())
                .gender(playerTransport.getGender())
                .build();
    }
}
