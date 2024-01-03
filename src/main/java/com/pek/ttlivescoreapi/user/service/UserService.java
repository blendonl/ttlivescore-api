package com.pek.ttlivescoreapi.user.service;

import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.user.exception.UserAlreadyExistException;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.transport.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {

    List<UserShortTransport> findAll(UserQueryTransport query) throws Exception;


    List<UserTransport> findAllByRole(String role);


    UserTransport save(UserSignupTransport user) throws TeamNotFoundException, UserAlreadyExistException, IOException;


    void deleteById(long id) throws UserNotFoundException;

    void deleteByEmail(String email) throws UserNotFoundException;

    UserTransport update(long id, UserUpdateTransport user) throws UserNotFoundException;


    UserTransport findById(long id) throws UserNotFoundException;

    UserTransport findByEmail(String email) throws UserNotFoundException;


    List<UserTransport> findAllByTeamId(long teamId);

    List<UserTransport> findAllByTeamName(String team);

    List<UserTransport> findAllOpponents(long playerId);


}
