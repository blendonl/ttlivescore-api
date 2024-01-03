package com.pek.ttlivescoreapi.user.service.impl;

import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.exception.UserAlreadyExistException;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.mapper.UserShortMapper;
import com.pek.ttlivescoreapi.user.mapper.UserSignupMapper;
import com.pek.ttlivescoreapi.user.repository.UserRepository;
import com.pek.ttlivescoreapi.user.service.UserService;
import com.pek.ttlivescoreapi.user.transport.*;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final MatchService matchService;

    public UserServiceImpl(UserRepository userRepository, MatchService matchService,
                           TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.matchService = matchService;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<UserShortTransport> findAll(UserQueryTransport query) throws Exception {
        if (query == null) {
            throw new Exception("bad query");
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
        User user = UserSignupMapper.mapUserSignupToUser(newUser);

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistException("user already exist");
        }

        Team team = teamRepository.findByName(newUser.getTeamName()).orElseThrow(TeamNotFoundException::new);

        user.getTeams().add(team);

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