package com.pek.ttlivescoreapi.controller;


import com.pek.ttlivescoreapi.config.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.dto.UserDto;
import com.pek.ttlivescoreapi.entity.User;
import com.pek.ttlivescoreapi.mapper.UserDtoMapper;
import com.pek.ttlivescoreapi.repository.UserRepository;
import com.pek.ttlivescoreapi.service.UserService;
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
        User user = UserDtoMapper.mapUserDtoToUser(userDto);

        user = userService.save(user);

        return userDto;
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable long userId) throws UserNotFoundException {

        User user = userService.findById(userId);
        return UserDtoMapper.mapUserToUserDto(user);
    }

    @GetMapping("/players")
    public List<UserDto> getAllPlayers() {

        List<User> users = userService.findAllByRole("PLAYER");

        return UserDtoMapper.mapUsersToUsersDto(users);
    }

    @GetMapping("find/{email}")
    public UserDto findByEmail(@PathVariable String email) {

        User user = userService.findByEmail(email);

        return UserDtoMapper.mapUserToUserDto(user);

    }



}
