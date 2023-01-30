package com.pek.ttlivescoreapi.user.service.impl;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.dto.UserDto;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.mapper.UserDtoMapper;
import com.pek.ttlivescoreapi.user.repository.UserRepository;
import com.pek.ttlivescoreapi.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllByRole(String role) {
        return UserDtoMapper.usersToUsersDto(userRepository.findAllByRoleName(role));
    }


    public UserDto save(User user) {
         return UserDtoMapper.userToUserDto(userRepository.save(user));
    }


    public void deleteById(long id) throws UserNotFoundException {

        if(!userRepository.existsById(id))
            throw new UserNotFoundException();
        userRepository.deleteById(id);
    }

    public UserDto findById(long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return UserDtoMapper.userToUserDto(user);
    }

    public UserDto findByEmail(String email) throws UserNotFoundException {

        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        return UserDtoMapper.userToUserDto(user);
    }

    public List<UserDto> findAllByTeamId(long teamId) {
        return UserDtoMapper.usersToUsersDto( userRepository.findAllByTeamId(teamId));
    }
    public List<UserDto> findAllByTeamName(String team) {

        return UserDtoMapper.usersToUsersDto(userRepository.findAllByTeamName(team));
    }


}
