package org.example.hockeymonitoring.modules.athlete.dto;

import lombok.Getter;

@Getter
public class CreateAthleteDto {
    private Long userId;
    private Long trainingMethodId;
    private Long teamRoleId;
    private Long categoryId;
    private int rating;
    private String gender;
    private int positionNumber;
}
