package com.pek.ttlivescoreapi.match.transport;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SetShortTransport {
    private long teamAPoints;
    private long teamBPoints;
    private boolean isFinished;
}
