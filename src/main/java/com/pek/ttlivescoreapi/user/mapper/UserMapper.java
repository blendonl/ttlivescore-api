package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public class UserMapper {


    public static List<UserTransport> mapToUsersTransport(List<User> users) {
        return users.stream().map(UserMapper::mapToUserTransport).toList();
    }

    @SneakyThrows
    public static UserTransport mapToUserTransport(User user) {


        return UserTransport.builder()
                .id(user.getId())
                .profilePicture(user.getProfilePicture())
                .firstName(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .teamName(user.getTeams().get(user.getTeams().size() - 1).getName())
                .gender(user.getGender())
                .build();
    }

    @SneakyThrows
    public static User mapToUser(UserTransport userTransport) {
        User.UserBuilder user = User.builder()
                .id(userTransport.getId())
                .profilePicture(userTransport.getProfilePicture())
                .name(userTransport.getFirstName())
                .lastName(userTransport.getLastName())
                .teams(Arrays.stream(new Team[]{Team.builder().name(userTransport.getTeamName()).build()}).toList())
                .email(userTransport.getEmail())
                .birthDate(userTransport.getBirthDate())
                .gender(userTransport.getGender());

        return user.build();


    }
}