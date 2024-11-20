package org.example.hockeymonitoring.modules.hockeyteam.controllers;

import org.example.hockeymonitoring.modules.hockeyteam.models.HockeyTeam;
import org.example.hockeymonitoring.modules.hockeyteam.services.HockeyTeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teams_old")
@AllArgsConstructor
public class HockeyTeamController {
    private final HockeyTeamService hockeyTeamService;

    @GetMapping
    public List<HockeyTeam> getHockeyTeams() {
        return new ArrayList<>();
    }
}
