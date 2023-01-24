package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.dto.SignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public void signup(SignupRequestDto request, String role) {

    }
}
