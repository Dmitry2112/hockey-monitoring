package org.example.hockeymonitoring.modules.team.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class AddAthletesDto {
    private final List<Long> athleteIds;

    public AddAthletesDto(List<Long> athleteIds) {
        this.athleteIds = athleteIds;
    }
}
