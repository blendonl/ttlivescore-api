package com.pek.ttlivescoreapi.user.service;

import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {



    List<UserTransport> findAllByRole(String role);


    UserTransport save(User user);


    void deleteById(long id) throws UserNotFoundException;


    UserTransport findById(long id) throws UserNotFoundException;

    UserTransport findByEmail(String email) throws UserNotFoundException;

    List<UserTransport> findAllByTeamId(long teamId);
    List<UserTransport> findAllByTeamName(String team);



}
