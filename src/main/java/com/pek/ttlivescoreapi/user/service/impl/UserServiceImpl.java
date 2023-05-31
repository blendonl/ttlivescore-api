package com.pek.ttlivescoreapi.user.service.impl;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.repository.UserRepository;
import com.pek.ttlivescoreapi.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserTransport> findAllByRole(String role) {
        return UserMapper.mapToUsersTransport(userRepository.findAllByRoleName(role));
    }


    public UserTransport save(User user) {
         return UserMapper.mapToUserTransport(userRepository.save(user));
    }


    public void deleteById(long id) throws UserNotFoundException {

        if(!userRepository.existsById(id))
            throw new UserNotFoundException();
        userRepository.deleteById(id);
    }

    public UserTransport findById(long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return UserMapper.mapToUserTransport(user);
    }

    public UserTransport findByEmail(String email) throws UserNotFoundException {

        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        return UserMapper.mapToUserTransport(user);
    }

    public List<UserTransport> findAllByTeamId(long teamId) {
        return UserMapper.mapToUsersTransport( userRepository.findAllByTeamId(teamId));
    }
    public List<UserTransport> findAllByTeamName(String team) {

        return UserMapper.mapToUsersTransport(userRepository.findAllByTeamName(team));
    }


}
