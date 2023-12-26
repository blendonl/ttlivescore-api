package com.pek.ttlivescoreapi.user.service.impl;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.mapper.UserShortMapper;
import com.pek.ttlivescoreapi.user.service.DecodedMultipartFile;
import com.pek.ttlivescoreapi.user.transport.PlayerTransport;
import com.pek.ttlivescoreapi.user.transport.UserShortTransport;
import com.pek.ttlivescoreapi.user.transport.UserSignupTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.repository.UserRepository;
import com.pek.ttlivescoreapi.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MatchService matchService;
    private final TeamRepository teamRepository;

    public UserServiceImpl(UserRepository userRepository, MatchService matchService,
                           TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.matchService = matchService;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<UserShortTransport> findAll(String query) throws Exception {
        if(query == null) {
            throw new Exception("bad query");
        }

        return UserShortMapper.mapToUserShortsTransport((List<User>) userRepository.findAll());

    }

    @SneakyThrows
    @Transactional
    public List<UserTransport> findAllByRole(String role) {
//        List<User> users = userRepository.findAllByRolesContaining(Role.builder().name(role).build());
        return UserMapper.mapToUsersTransport((List<User>) userRepository.findAll());
    }


    public UserTransport save(UserSignupTransport userTransport) {
        User user = UserMapper.mapUserSignupToUser(userTransport);


        user.getTeams().get(0).setId(teamRepository.findByName(user.getTeams().get(0).getName()).get().getId());

        System.out.println(user.getTeams().get(0).getId());

        UserTransport userT = UserMapper.mapToUserTransport(userRepository.save(user));

        return userT;

    }


    public void deleteById(long id) throws UserNotFoundException {

        if(!userRepository.existsById(id))
            throw new UserNotFoundException();
        userRepository.deleteById(id);
    }


    @Transactional
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

    @Override
    public List<UserTransport> findAllOpponents(long playerId) {
        return null;
    }


}