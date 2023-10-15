package com.pek.ttlivescoreapi.match.transport;

import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.PlayerTransport;
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
    private boolean isFinished;
    private List<String> players = new ArrayList<>();
    private UserTransport referee;
}
