package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserSignupTransport;

import java.io.IOException;
import java.util.Arrays;

public class UserSignupMapper {

    public static User mapUserSignupToUser(UserSignupTransport user) throws IOException {

        return User.builder()
                .profilePicture(user.getProfilePicture() != null
                        ? user.getProfilePicture().getBytes()
                        : null)
                .name(user.getFirstName())
                .lastName(user.getLastName())
                .teams(Arrays.stream(new Team[]{Team.builder().name(user.getTeamName()).build()}).toList())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthDate(user.getBirthDate())
                .gender(user.getGender()).build();


    }
}
