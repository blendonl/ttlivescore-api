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
    private long id;
    private String name;
    private List<TeamLeagueTransport> leagues;
    private List<UserShortTransport> users;
}
