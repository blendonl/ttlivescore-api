package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeekUpdateTransport {
    private Date date;
}
