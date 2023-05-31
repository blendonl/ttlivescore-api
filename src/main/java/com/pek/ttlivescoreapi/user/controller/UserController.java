package com.pek.ttlivescoreapi.user.controller;


import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UserTransport saveUser(@RequestBody UserTransport userTransport) {
        User user = UserMapper.mapToUser(userTransport);

        return userService.save(user);

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



}
