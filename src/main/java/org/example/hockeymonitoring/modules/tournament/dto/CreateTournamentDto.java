package org.example.hockeymonitoring.modules.tournament.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateTournamentDto {
    private LocalDate date;
    private Long typeId;
}
