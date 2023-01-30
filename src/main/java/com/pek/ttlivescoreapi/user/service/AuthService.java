package com.pek.ttlivescoreapi.user.service;

import com.pek.ttlivescoreapi.user.transport.SignUpRequestTransport;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public void signup(SignUpRequestTransport request, String role) {

    }
}
