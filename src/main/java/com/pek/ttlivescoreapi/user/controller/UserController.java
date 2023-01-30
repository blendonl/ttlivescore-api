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

        user = userService.save(user);

        return userTransport;
    }

    @GetMapping("/{userId}")
    public UserTransport getUserById(@PathVariable long userId) throws UserNotFoundException {

        User user = userService.findById(userId);
        return UserMapper.mapToUserTransport(user);
    }

    @GetMapping("/players")
    public List<UserTransport> getAllPlayers() {

        List<User> users = userService.findAllByRole("PLAYER");

        return UserMapper.mapToUsersTransport(users);
    }

    @GetMapping("find/{email}")
    public UserTransport findByEmail(@PathVariable String email) {

        User user = userService.findByEmail(email);

        return UserMapper.mapToUserTransport(user);

    }



}
