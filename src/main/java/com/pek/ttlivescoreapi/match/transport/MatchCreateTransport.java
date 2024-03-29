package com.pek.ttlivescoreapi.match.transport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchCreateTransport {
    private List<GroupShortTransport> players;
}
