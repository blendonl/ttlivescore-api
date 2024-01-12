package com.pek.ttlivescoreapi.user.transport;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupTransport {

    private MultipartFile profilePicture;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
    private char gender;
}
