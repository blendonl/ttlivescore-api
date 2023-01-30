package com.pek.ttlivescoreapi.user.mapper;

import com.pek.ttlivescoreapi.user.dto.UserDto;
import com.pek.ttlivescoreapi.user.entity.User;

import java.util.List;

public class UserDtoMapper {

    public static UserDto userToUserDto(User user) {
         return UserDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .build();
    }

    public static List<UserDto> usersToUsersDto(List<User> users) {
        return users.stream().map(UserDtoMapper::userToUserDto).toList();
    }


    public static User userDtoToUser(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .birthDate(userDto.getBirthDate())
                .gender(userDto.getGender())
                .build();
    }
}
