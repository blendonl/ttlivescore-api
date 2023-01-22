package com.pek.ttlivescoreapi.service;

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
        return userRepository.findAllByRole(role);
    }


}
