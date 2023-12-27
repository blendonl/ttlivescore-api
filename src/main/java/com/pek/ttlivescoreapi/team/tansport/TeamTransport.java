package com.pek.ttlivescoreapi.team.tansport;

import com.pek.ttlivescoreapi.user.transport.UserShortTransport;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamTransport {
    private String name;
    private String leagueName;
    private List<UserShortTransport> users;
}
