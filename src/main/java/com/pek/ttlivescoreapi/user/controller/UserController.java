package com.pek.ttlivescoreapi.user.controller;


import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.user.exception.UserAlreadyExistException;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.service.UserService;
import com.pek.ttlivescoreapi.user.transport.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public List<UserShortTransport> findAll(UserQueryTransport query) throws Exception {
        return this.userService.findAll(query);
    }

    @PostMapping
    public UserTransport saveUser(@RequestBody UserSignupTransport userTransport) throws TeamNotFoundException, UserAlreadyExistException, IOException {
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

    @DeleteMapping("{userId}")
    public void deleteById(@PathVariable long userId) throws UserNotFoundException {
        userService.deleteById(userId);
    }

    @DeleteMapping("find/{userEmail}")
    public void deleteByEmail(@PathVariable String userEmail) throws UserNotFoundException {
        userService.deleteByEmail(userEmail);
    }

    @PatchMapping("{id}")
    public UserTransport update(@PathVariable long id, @RequestBody UserUpdateTransport user) throws UserNotFoundException {
        return userService.update(id, user);
    }

}