package com.pek.ttlivescoreapi.dto;

import com.pek.ttlivescoreapi.entity.User;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private char gender;



}
