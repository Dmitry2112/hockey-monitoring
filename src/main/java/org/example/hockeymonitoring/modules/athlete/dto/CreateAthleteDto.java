package org.example.hockeymonitoring.modules.athlete.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.athlete.TeamRole;

@Getter
public class CreateAthleteDto {
    private Long userId;
    private Long trainingMethodId;
    private TeamRole teamRole;
    private Long categoryId;
    private int rating;
    private String gender;
    private int positionNumber;
}
