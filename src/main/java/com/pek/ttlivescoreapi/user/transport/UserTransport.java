package com.pek.ttlivescoreapi.user.transport;

import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.match.transport.PlayerMatchTransport;
import lombok.*;

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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private char gender;
    private String teamName;
    private List<PlayerMatchTransport> matches = new ArrayList<>();
}
