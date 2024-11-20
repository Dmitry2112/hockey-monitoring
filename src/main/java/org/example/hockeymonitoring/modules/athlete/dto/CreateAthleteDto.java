package org.example.hockeymonitoring.modules.athlete.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.athlete.Athlete;

@Getter
public class CreateAthleteDto {
    private Long userId;
    private Long trainingMethodId;
    private Long teamRoleId;
    private Long categoryId;
    private Athlete athlete;
}
