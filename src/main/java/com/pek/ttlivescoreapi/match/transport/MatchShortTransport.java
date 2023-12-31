package com.pek.ttlivescoreapi.match.transport;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchShortTransport {
    private long id;
    private List<SetShortTransport> sets;
    private boolean isFinished;
}
