package com.pek.ttlivescoreapi.user.controller;


import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.transport.*;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final MatchService matchService;

    public UserController(UserService userService, MatchService matchService) {
        this.userService = userService;
        this.matchService = matchService;
    }

    @GetMapping
    public List<UserShortTransport> findAll(@RequestParam(required = false) UserQueryTransport query) throws Exception {
        return this.userService.findAll(query);

    }

    @PostMapping
    public UserTransport saveUser(@ModelAttribute UserSignupTransport userTransport) {
        return userService.save(userTransport);
    }

    @GetMapping("/{userId}")
    public UserTransport getUserById(@PathVariable long userId) throws UserNotFoundException {

        return userService.findById(userId);
    }

    @GetMapping("/players")
    public List<UserTransport> getAllPlayers() {

        return userService.findAllByRole("PLAYER");

    }

    @GetMapping("find/{email}")
    public UserTransport findByEmail(@PathVariable String email) throws UserNotFoundException {
        return userService.findByEmail(email);
    }

    @GetMapping("{userId}/matches")
    public List<MatchTransport> findAllMatchesById(@PathVariable long userId) {
//        return matchService.findAllByPlayerId(userId);

        return matchService.findALlByPlayer1IdAndPlayer2Id(userId, 2);
    }



}