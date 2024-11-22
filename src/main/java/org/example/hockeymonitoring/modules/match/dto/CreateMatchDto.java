package org.example.hockeymonitoring.modules.match.dto;

import lombok.Getter;

@Getter
public class CreateMatchDto {
    private Long tournamentId;
    private Long firstTeamId;
    private Long secondTeamId;
    private Long typeId;
}
