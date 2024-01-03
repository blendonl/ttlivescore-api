package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventShortTransport {
    private long id;
    private String name;
    private Date date;
    private char gender;
}
