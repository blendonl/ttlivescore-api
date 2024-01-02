package com.pek.ttlivescoreapi.event.controller;

import com.pek.ttlivescoreapi.event.service.WeekService;
import com.pek.ttlivescoreapi.event.transport.WeekCreateTransport;
import com.pek.ttlivescoreapi.event.transport.WeekShortTransport;
import com.pek.ttlivescoreapi.event.transport.WeekTransport;
import com.pek.ttlivescoreapi.event.transport.WeekUpdateTransport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events/weeks")
public class WeekController {

    private final WeekService weekService;

    public WeekController(WeekService weekService) {
        this.weekService = weekService;
    }

    @GetMapping("{seasonId}")
    public WeekTransport getById(@PathVariable long seasonId) {
        return this.weekService.findById(seasonId);
    }

    @GetMapping("")
    public List<WeekShortTransport> getAll() {
        return this.weekService.findAll();
    }

    @PostMapping("")
    public WeekShortTransport save(@RequestBody WeekCreateTransport week) {
        return this.weekService.save(week);
    }

    @PostMapping("{weekId}")
    public WeekShortTransport update(@PathVariable long weekId, @RequestBody WeekUpdateTransport week) {
        return this.weekService.update(weekId, week);
    }
}
