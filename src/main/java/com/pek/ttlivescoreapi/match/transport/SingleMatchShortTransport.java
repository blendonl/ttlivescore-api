package com.pek.ttlivescoreapi.match.transport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleMatchShortTransport extends MatchShortTransport {
    private String playerAName;
    private String playerBName;
}
