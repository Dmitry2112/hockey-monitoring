package org.example.hockeymonitoring.modules.athlete.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.athlete.models.Athlete;

@Getter
public class UpdateAthleteDto {
    private Long userId;
    private Athlete athlete;
}
