package com.pek.ttlivescoreapi.user.controller;

import com.pek.ttlivescoreapi.user.transport.SignUpRequestTransport;
import com.pek.ttlivescoreapi.user.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("signup")
    public void signup(@RequestBody SignUpRequestTransport request) {
        authService.signup(request, "PLAYER");
    }
}
