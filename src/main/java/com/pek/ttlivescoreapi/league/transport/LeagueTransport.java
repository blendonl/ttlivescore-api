package com.pek.ttlivescoreapi.league.transport;


import com.pek.ttlivescoreapi.team.tansport.TeamShortTransport;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueTransport {
    private long id;
    private String name;
    private String category;
    private List<TeamShortTransport> teams;

}
