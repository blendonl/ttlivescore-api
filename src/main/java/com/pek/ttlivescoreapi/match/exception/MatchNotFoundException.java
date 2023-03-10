package com.pek.ttlivescoreapi.match.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchNotFoundException extends RuntimeException {
    private String matchId;
}
