package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.user.transport.UserSignupTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.user.entity.User;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserMapper {

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
    public static User mapUserSignupToUser(UserSignupTransport user) {

        return User.builder()
                .profilePicture(user.getProfilePicture().getBytes())
                .name(user.getFirstName())
                .lastName(user.getLastName())
                .teams(Arrays.stream(new Team[]{Team.builder().name(user.getTeamName()).build()}).toList())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthDate(user.getBirthDate())
                .gender(user.getGender()).build();


    }

    public static UserTransport mapToUserTransportWithoutMatches(User user) {
        return UserTransport.builder()
                .id(user.getId())
//                .profilePicture(new DecodedMultipartFile(user.getProfilePicture()))
//                .profilePicture(user.getProfilePicture())
                .firstName(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
//                .teamName(user.getTeam().getName())
                .gender(user.getGender())
                .build();
    }

    public static List<UserTransport> mapToUsersTransport(List<User> users) {
        return users.stream().map(UserMapper::mapToUserTransport).toList();
    }


    @SneakyThrows
    public static User mapToUser(UserTransport userTransport) {
       User.UserBuilder user =  User.builder()
                .id(userTransport.getId())
                .profilePicture(userTransport.getProfilePicture())
                .name(userTransport.getFirstName())
                .lastName(userTransport.getLastName())
               .teams(Arrays.stream(new Team[]{Team.builder().name(userTransport.getTeamName()).build()}).toList())
                .email(userTransport.getEmail())
                .password(userTransport.getPassword())
                .birthDate(userTransport.getBirthDate())
                .gender(userTransport.getGender());

       return user.build();



    }
}