package org.example.hockeymonitoring.modules.match.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.match.MatchStatus;
import org.example.hockeymonitoring.modules.match.MatchType;

import java.time.LocalDate;

@Getter
public class CreateMatchDto {
    private final Long tournamentId;
    private final Long firstTeamId;
    private final Long secondTeamId;
    private final int firstTeamScore;
    private final int secondTeamScore;
    private final MatchType type;
    private final String gender;
    private final MatchStatus status;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public CreateMatchDto(
        Long tournamentId,
        Long firstTeamId,
        Long secondTeamId,
        int firstTeamScore,
        int secondTeamScore,
        MatchType type,
        String gender,
        MatchStatus status,
        LocalDate startDate,
        LocalDate endDate
    ) {
        this.tournamentId = tournamentId;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
        this.type = type;
        this.gender = gender;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
