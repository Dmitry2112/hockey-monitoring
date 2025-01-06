package org.example.hockeymonitoring.modules.match.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.match.MatchStatus;

import java.time.LocalDate;

@Getter
public class
CreateMatchDto {
    private Long tournamentId;
    private Long firstTeamId;
    private Long secondTeamId;
    private Long typeId;
    private String gender;
    private MatchStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
}
