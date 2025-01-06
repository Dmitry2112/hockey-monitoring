package org.example.hockeymonitoring.modules.tournament.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.tournament.TournamentStatus;

import java.time.LocalDate;

@Getter
public class CreateTournamentDto {
    private LocalDate date;
    private Long typeId;
    private String gender;
    private TournamentStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
}
