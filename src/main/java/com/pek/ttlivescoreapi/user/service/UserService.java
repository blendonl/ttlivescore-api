package com.pek.ttlivescoreapi.user.service;

import com.pek.ttlivescoreapi.user.dto.UserDto;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {



    List<UserDto> findAllByRole(String role);


    UserDto save(User user);


    void deleteById(long id) throws UserNotFoundException;


    UserDto findById(long id) throws UserNotFoundException;

    UserDto findByEmail(String email) throws UserNotFoundException;

    List<UserDto> findAllByTeamId(long teamId);
    List<UserDto> findAllByTeamName(String team);



}
