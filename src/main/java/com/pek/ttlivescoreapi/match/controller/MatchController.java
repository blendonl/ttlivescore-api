package com.pek.ttlivescoreapi.match.controller;


import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.match.service.PointService;
import com.pek.ttlivescoreapi.match.transport.*;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController()
@RequestMapping("match")
public class MatchController {

    private final CopyOnWriteArrayList<SseEmitter> pointsEmitters = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<SseEmitter> matchesEmitters = new CopyOnWriteArrayList<>();


    private final MatchService matchService;

    private final PointService pointService;


    public MatchController(MatchService service, PointService pointService) {
        this.matchService = service;
        this.pointService = pointService;
//        this.matchPlayerService = matchPlayerService;
    }


    @GetMapping("{matchId}/points/rt")
    public SseEmitter pointsRt(@PathVariable long matchId) {
        SseEmitter emitter = new SseEmitter();
        pointsEmitters.add(emitter);

        System.out.println(matchId);


        emitter.onCompletion(() -> pointsEmitters.remove(emitter));
        emitter.onTimeout(() -> pointsEmitters.remove(emitter));

        return emitter;
    }

    @GetMapping("set/rt")
    public SseEmitter setRt() {
        SseEmitter emitter = new SseEmitter();
        matchesEmitters.add(emitter);

        emitter.onCompletion(() -> matchesEmitters.remove(emitter));
        emitter.onTimeout(() -> matchesEmitters.remove(emitter));

        return emitter;
    }

    @GetMapping("{matchId}/points")
    public List<PointTransport> points(@PathVariable long matchId) {

        return pointService.findAllByMatchId(matchId);

    }


    public void sendPointsToEmitters(PointTransport data) {
        for (SseEmitter emmiter :
                pointsEmitters) {
            try {
                emmiter.send(data);
            } catch (Exception ignored) {

            }
        }
    }

    public void sendMatchesToEmitters(List<MatchShortTransport> matchTransports) {
        for (SseEmitter emmiter :
                pointsEmitters) {
            try {
                emmiter.send(matchTransports);
            } catch (Exception ignored) {

            }
        }
    }

    @PostMapping("{matchId}")
    public PointTransport savePoint(@RequestBody PointTransport pointTransport, @PathVariable long matchId) {
        pointTransport = pointService.save(pointTransport);
        sendPointsToEmitters(pointTransport);
        sendMatchesToEmitters(matchService.findAll());
        return pointTransport;
    }

    @PostMapping("")
    public MatchShortTransport save(@RequestBody MatchCreateTransport newMatch) {
        return matchService.save(newMatch);
    }

    @PatchMapping("{matchId}")
    public MatchShortTransport update(@PathVariable long matchId, @RequestBody MatchUpdateTransport match) {
        return matchService.update(matchId, match);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        matchService.deleteById(id);
    }


//    @GetMapping("{matchId}")
//    public MatchTransport getMatchById(@PathVariable long matchId) {
//        return matchService.findById(matchId);
//    }


    @GetMapping("/{singleMatchId}/{playerId}")
    public int getPlayerPointsInASingleMatch(@PathVariable long singleMatchId, @PathVariable long playerId) {
//        return service.getPlayersPointInASingleMatch(singleMatchId, playerId);
        return 0;
    }

    @GetMapping("/{singleMatchId}/winner")
    public UserTransport getWinnerInASingleMatch(@PathVariable long singleMatchId) {

        UserTransport user = (matchService.getWinnerInASingleMatch(singleMatchId));

        return user;
    }

    @GetMapping("single/{player1Id}/{player2Id}")
    public List<MatchTransport> getSingleMatchesByPlayer1IdAndPlayer2Id(@PathVariable long player1Id, @PathVariable long player2Id) {
        return matchService.findALlByPlayer1IdAndPlayer2Id(player1Id, player2Id);

    }


    @GetMapping()
    public List<MatchShortTransport> getMatches() {
        return matchService.findAll();
    }

    @PostMapping("{matchId}/players")
    public UserTransport addPlayer(@PathVariable long matchId, @RequestBody UserTransport user) {

//        matchPlayerService.save(matchId, user);

        return null;

    }


}
