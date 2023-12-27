package com.pek.ttlivescoreapi.user.service;

import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.user.transport.*;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserShortTransport> findAll(UserQueryTransport query) throws Exception;



    List<UserTransport> findAllByRole(String role);


    UserTransport save(UserSignupTransport user) throws TeamNotFoundException;


    void deleteById(long id) throws UserNotFoundException;


    UserTransport findById(long id) throws UserNotFoundException;

    UserTransport findByEmail(String email) throws UserNotFoundException;


    List<UserTransport> findAllByTeamId(long teamId);
    List<UserTransport> findAllByTeamName(String team);

    List<UserTransport> findAllOpponents(long playerId);



}
