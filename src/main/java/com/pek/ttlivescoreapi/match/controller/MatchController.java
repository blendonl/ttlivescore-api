package com.pek.ttlivescoreapi.match.controller;


import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.match.service.MatchPlayerService;
import com.pek.ttlivescoreapi.match.service.PointService;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.match.transport.PointTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import com.pek.ttlivescoreapi.match.service.MatchService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController()
@RequestMapping("match")
public class MatchController {

    private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    private MatchService matchService;

    private PointService pointService;
    private MatchPlayerService matchPlayerService;


    public MatchController(MatchService service, PointService pointService) {
        this.matchService = service;
        this.pointService = pointService;
    }



    @GetMapping("{matchId}/rt")
    public SseEmitter pointsRt(@PathVariable long matchId) {
        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);

        System.out.println(matchId);



        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));

        return emitter;
    }

    @GetMapping("{matchId}")
    public List<PointTransport> points(@PathVariable long matchId) {

        return pointService.findAllByMatchId(matchId);

    }

    public void sendDataToClients(PointTransport data) {
        for (SseEmitter emmiter :
                emitters) {
            try {
                emmiter.send(data);
            }catch (Exception ignored) {

            }
        }
    }

    @PostMapping("")
    public MatchTransport save(@RequestBody MatchTransport matchTransport) {
        return matchService.save(matchTransport);
    }

    @PatchMapping( )
    public MatchTransport update(@RequestBody MatchTransport matchTransport) {
        return matchService.update(matchTransport);
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


    @PostMapping("{matchId}")
    public PointTransport savePoint(@RequestBody PointTransport pointTransport, @PathVariable long matchId) {
        pointTransport = pointService.save(pointTransport);
        sendDataToClients(pointTransport);
        return pointTransport;
    }


    @GetMapping()
    public List<MatchTransport> getMatches() {

        return matchService.findAll();

    }


}
