package com.pek.ttlivescoreapi.user.transport;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupTransport {

    private MultipartFile profilePicture;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private char gender;
    private String teamName;
}
