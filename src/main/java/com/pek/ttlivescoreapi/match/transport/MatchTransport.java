package com.pek.ttlivescoreapi.match.transport;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pek.ttlivescoreapi.match.entity.MatchPlayer;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchTransport {

    private long id;
    private boolean finished;
    private List<MatchPlayerTransport> matchPlayers = new ArrayList<>();
    private UserTransport referee;
}
