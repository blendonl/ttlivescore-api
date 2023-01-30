package com.pek.ttlivescoreapi.service;

import com.pek.ttlivescoreapi.user.dto.SignupRequestDto;
import com.pek.ttlivescoreapi.user.service.UserService;
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
