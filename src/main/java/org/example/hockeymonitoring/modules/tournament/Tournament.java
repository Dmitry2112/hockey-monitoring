package org.example.hockeymonitoring.modules.tournament;

import jakarta.persistence.*;
import lombok.Data;
import org.example.hockeymonitoring.modules.tournamenttype.TournamentType;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TournamentType type;

    private String gender;

    @Enumerated(EnumType.STRING)
    private TournamentStatus status;

    private LocalDate startDate;
    private LocalDate endDate;
}
