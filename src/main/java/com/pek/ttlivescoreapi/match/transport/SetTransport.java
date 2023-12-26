package com.pek.ttlivescoreapi.match.transport;

import com.pek.ttlivescoreapi.match.entity.Point;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetTransport {

    private long id;
    private MatchTransport match;
    private List<PointTransport> points;
    private boolean isFinished;
}
