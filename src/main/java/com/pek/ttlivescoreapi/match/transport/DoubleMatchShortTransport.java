package com.pek.ttlivescoreapi.match.transport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleMatchShortTransport extends SingleMatchShortTransport {
    private String playerAAName;
    private String playerBBName;
}
