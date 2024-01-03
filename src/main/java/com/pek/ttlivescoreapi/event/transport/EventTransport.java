package com.pek.ttlivescoreapi.event.transport;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventTransport {

    private long id;
    private String name;
    private Date date;
    private String type;
}
