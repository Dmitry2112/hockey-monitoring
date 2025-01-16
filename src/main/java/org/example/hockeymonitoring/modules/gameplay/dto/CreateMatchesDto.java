package org.example.hockeymonitoring.modules.gameplay.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.match.MatchStatus;
import org.example.hockeymonitoring.modules.match.MatchType;

import java.time.LocalDate;

@Getter
public class CreateMatchesDto {
    private Long tournamentId;
    private MatchType type;
    private String gender;
    private MatchStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
}
