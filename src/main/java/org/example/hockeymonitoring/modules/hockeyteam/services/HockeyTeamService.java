package org.example.hockeymonitoring.modules.hockeyteam.services;

import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.models.HockeyPlayer;
import org.example.hockeymonitoring.modules.athlete.services.HockeyPlayerService;
import org.example.hockeymonitoring.modules.hockeyteam.models.HockeyTeam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HockeyTeamService {
    private final HockeyPlayerService hockeyPlayerService;

    public List<HockeyTeam> getAllHockeyTeams() {
        List<HockeyPlayer> players = hockeyPlayerService.getAllHockeyPlayers();
        return List.of(
                HockeyTeam.builder()
                        .name("SuperTeam1")
                        .description("SuperTeam1 description")
                        .trainerId(1)
                        .players(players)
                        .build(),
                HockeyTeam.builder()
                        .name("SuperTeam2")
                        .description("SuperTeam2 description")
                        .trainerId(2)
                        .players(players)
                        .build(),
                HockeyTeam.builder()
                        .name("SuperTeam3")
                        .description("SuperTeam3 description")
                        .trainerId(3)
                        .players(players)
                        .build()
        );
    }
}
