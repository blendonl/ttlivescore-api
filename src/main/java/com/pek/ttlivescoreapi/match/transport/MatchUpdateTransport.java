package com.pek.ttlivescoreapi.match.transport;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchUpdateTransport {
    private long refereeId;
    private Date date;
}
