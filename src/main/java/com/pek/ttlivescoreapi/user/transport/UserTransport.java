package com.pek.ttlivescoreapi.user.transport;

import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.match.transport.PlayerMatchTransport;
import com.pek.ttlivescoreapi.user.service.DecodedMultipartFile;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTransport {

    private long id;
    private byte[] profilePicture;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private char gender;
    private String teamName;


}
