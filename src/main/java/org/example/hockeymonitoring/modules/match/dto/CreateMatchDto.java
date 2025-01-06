package org.example.hockeymonitoring.modules.match.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.match.MatchStatus;
import org.example.hockeymonitoring.modules.match.MatchType;

import java.time.LocalDate;

@Getter
public class CreateMatchDto {
    private Long tournamentId;
    private Long firstTeamId;
    private Long secondTeamId;
    private int firstTeamScore;
    private int secondTeamScore;
    private MatchType type;
    private String gender;
    private MatchStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
}
