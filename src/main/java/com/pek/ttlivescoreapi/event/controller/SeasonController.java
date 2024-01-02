package com.pek.ttlivescoreapi.event.controller;

import com.pek.ttlivescoreapi.event.service.SeasonService;
import com.pek.ttlivescoreapi.event.transport.SeasonTransport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seasons")
public class SeasonController {

    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping("{seasonId}")
    public SeasonTransport getById(@PathVariable long seasonId) {
        return this.seasonService.findById(seasonId);
    }
}
