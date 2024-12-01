package org.example.hockeymonitoring.modules.team.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class AddAthletesDto {
    private List<Long> athleteIds;
}
