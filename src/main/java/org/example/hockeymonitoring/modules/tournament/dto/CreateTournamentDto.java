package org.example.hockeymonitoring.modules.tournament.dto;

import lombok.Getter;
import org.example.hockeymonitoring.modules.tournament.TournamentStatus;
import org.example.hockeymonitoring.modules.tournament.TournamentType;

import java.time.LocalDate;

@Getter
public class CreateTournamentDto {
    private LocalDate date;
    private TournamentType type;
    private String gender;
    private TournamentStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
}
