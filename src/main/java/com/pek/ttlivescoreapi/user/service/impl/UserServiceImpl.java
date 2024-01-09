package com.pek.ttlivescoreapi.user.service.impl;

import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.user.entity.Role;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.exception.RoleNotFoundException;
import com.pek.ttlivescoreapi.user.exception.UserAlreadyExistException;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.mapper.UserShortMapper;
import com.pek.ttlivescoreapi.user.mapper.UserSignupMapper;
import com.pek.ttlivescoreapi.user.repository.RoleRepository;
import com.pek.ttlivescoreapi.user.repository.UserRepository;
import com.pek.ttlivescoreapi.user.service.UserService;
import com.pek.ttlivescoreapi.user.transport.*;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserShortTransport> findAll(UserQueryTransport query) throws Exception {
        if (query.getEmail() == null && query.getFirstName() == null && query.getLastName() == null) {
            return UserShortMapper.mapToUserShortsTransport(this.userRepository.findAll());
        }

        return UserShortMapper.mapToUserShortsTransport(userRepository.findAllWithQuery(query));

    }

    @SneakyThrows
    @Transactional
    public List<UserTransport> findAllByRole(String role) {
//        List<User> users = userRepository.findAllByRolesContaining(Role.builder().name(role).build());
        return UserMapper.mapToUsersTransport(userRepository.findAll());
    }


    public UserTransport save(UserSignupTransport newUser) throws TeamNotFoundException, UserAlreadyExistException, IOException {

        Role role = this.roleRepository.findById((long) Integer.parseInt(newUser.getRole())).orElseThrow(RoleNotFoundException::new);

        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new UserAlreadyExistException("user already exist");
        }

        User user = UserSignupMapper.mapUserSignupToUser(newUser);

        user.setRoles(new ArrayList<>());

        user.getRoles().add(role);

        return UserMapper.mapToUserTransport(userRepository.save(user));

    }

    public void deleteById(long id) throws UserNotFoundException {
        if (!userRepository.existsById(id))
            throw new UserNotFoundException();

        userRepository.deleteById(id);
    }

    public void deleteByEmail(String email) throws UserNotFoundException {
        if (!userRepository.existsByEmail(email))
            throw new UserNotFoundException();

        userRepository.deleteByEmail(email);
    }

    public UserTransport update(long id, UserUpdateTransport newUser) throws UserNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        user.setName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPassword(newUser.getPassword());

        this.userRepository.save(user);

        return UserMapper.mapToUserTransport(user);

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
        return UserMapper.mapToUsersTransport(userRepository.findAllByTeamId(teamId));
    }

    public List<UserTransport> findAllByTeamName(String team) {

        return UserMapper.mapToUsersTransport(userRepository.findAllByTeamName(team));
    }

    @Override
    public List<UserTransport> findAllOpponents(long playerId) {
        return null;
    }

}