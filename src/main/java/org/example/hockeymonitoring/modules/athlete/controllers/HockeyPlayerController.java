package org.example.hockeymonitoring.modules.athlete.controllers;

import org.example.hockeymonitoring.modules.athlete.models.HockeyPlayer;
import org.example.hockeymonitoring.modules.athlete.services.HockeyPlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hockeyplayers")
public class HockeyPlayerController {
    private final HockeyPlayerService hockeyPlayerService;

    public HockeyPlayerController() {
        this.hockeyPlayerService = HockeyPlayerService.getInstance();
    }

    @GetMapping
    public List<HockeyPlayer> getHockeyPlayers() {
        return hockeyPlayerService.getAllHockeyPlayers();
    }
}
