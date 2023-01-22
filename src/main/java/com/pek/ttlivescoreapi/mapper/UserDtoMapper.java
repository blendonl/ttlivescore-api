package com.pek.ttlivescoreapi.mapper;

import com.pek.ttlivescoreapi.dto.UserDto;
import com.pek.ttlivescoreapi.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoMapper {

    public static UserDto mapUserToUserDto(User user) {
         return UserDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .build();
    }

    public static List<UserDto> mapUsersToUsersDto(List<User> users) {
        return users.stream().map(UserDtoMapper::mapUserToUserDto).toList();
    }


}
