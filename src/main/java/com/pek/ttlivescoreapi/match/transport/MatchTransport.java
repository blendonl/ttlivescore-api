package com.pek.ttlivescoreapi.match.transport;

import com.pek.ttlivescoreapi.user.transport.UserTransport;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchTransport {
    private long id;
    private boolean isFinished;
    private boolean isDouble;
    private List<GroupTransport> players;
    private UserTransport referee;
}
