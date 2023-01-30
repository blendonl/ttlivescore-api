package com.pek.ttlivescoreapi.user.controller;


import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.dto.UserDto;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.mapper.UserDtoMapper;
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
    public UserDto saveUser(@RequestBody UserDto userDto) {
        User user = UserDtoMapper.userDtoToUser(userDto);

        user = userService.save(user);

        return userDto;
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable long userId) throws UserNotFoundException {

        User user = userService.findById(userId);
        return UserDtoMapper.userToUserDto(user);
    }

    @GetMapping("/players")
    public List<UserDto> getAllPlayers() {

        List<User> users = userService.findAllByRole("PLAYER");

        return UserDtoMapper.usersToUsersDto(users);
    }

    @GetMapping("find/{email}")
    public UserDto findByEmail(@PathVariable String email) {

        User user = userService.findByEmail(email);

        return UserDtoMapper.userToUserDto(user);

    }



}
