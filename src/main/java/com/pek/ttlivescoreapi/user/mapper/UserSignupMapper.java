package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserSignupTransport;

import java.io.IOException;
import java.sql.Date;

public class UserSignupMapper {

    public static User mapUserSignupToUser(UserSignupTransport user) throws IOException {
        System.out.println(user.getBirthDate());

        return User.builder()
                .profilePicture(user.getProfilePicture() != null
                        ? user.getProfilePicture().getBytes()
                        : null)
                .name(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthDate(Date.valueOf(user.getBirthDate()))
                .gender(user.getGender()).build();


    }
}
