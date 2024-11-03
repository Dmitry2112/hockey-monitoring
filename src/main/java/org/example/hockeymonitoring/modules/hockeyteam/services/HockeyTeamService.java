package org.example.hockeymonitoring.modules.hockeyteam.services;

import lombok.AllArgsConstructor;
import org.example.hockeymonitoring.modules.athlete.services.AthleteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HockeyTeamService {
    private final AthleteService hockeyPlayerService;
}
