package com.pek.ttlivescoreapi.controller;


import com.pek.ttlivescoreapi.dto.UserDto;
import com.pek.ttlivescoreapi.entity.User;
import com.pek.ttlivescoreapi.mapper.UserDtoMapper;
import com.pek.ttlivescoreapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
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
}
