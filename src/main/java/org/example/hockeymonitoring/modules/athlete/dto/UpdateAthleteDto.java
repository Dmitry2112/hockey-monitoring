package org.example.hockeymonitoring.modules.athlete.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.athlete.Athlete;

@Getter
public class UpdateAthleteDto {
    private Long userId;
    private Athlete athlete;
}
