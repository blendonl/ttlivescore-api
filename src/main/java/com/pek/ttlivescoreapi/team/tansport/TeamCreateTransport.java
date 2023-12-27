package com.pek.ttlivescoreapi.team.tansport;

import com.pek.ttlivescoreapi.team.Team;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreateTransport {
    private String name;

    public static Team toTeam(TeamCreateTransport newTeam) {
        Team.builder()
                .name(newTeam.getName())
                .build();

    }
}
