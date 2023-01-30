package com.pek.ttlivescoreapi.league.service;


import com.pek.ttlivescoreapi.league.dto.LeagueDto;

import java.util.List;

public interface LeagueService {

    LeagueDto save(LeagueDto leagueDto);
    List<LeagueDto> findAll();
    void deleteById(long id);

    LeagueDto findById(long id);
}
