package org.example.hockeymonitoring.modules.hockeyteam.services;

import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.AthleteService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HockeyTeamService {
    private final AthleteService hockeyPlayerService;
}
