package com.pek.ttlivescoreapi.match.transport;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerMatchTransport {

    private List<String> opponentsFullName;
    private String refereeFullName;
    private boolean finished;
    private long pointsWon;
    private long pointsLost;
    private boolean isAWin;
}
