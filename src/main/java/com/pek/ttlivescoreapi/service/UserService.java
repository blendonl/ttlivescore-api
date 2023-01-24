package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.config.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.entity.User;
import com.pek.ttlivescoreapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllByRole(String role) {
        return userRepository.findAllByRoleName(role);
    }


    public User save(User user) {
        return userRepository.save(user);
    }


    public void deleteById(long id) throws UserNotFoundException {

        if(!userRepository.existsById(id))
            throw new UserNotFoundException();
        userRepository.deleteById(id);
    }

    public User findById(long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllByTeamId(long teamId) {
        return userRepository.findAllByTeamId(teamId);
    }
    public List<User> findAllByTeamName(String team) {
        return userRepository.findAllByTeamName(team);
    }



}
