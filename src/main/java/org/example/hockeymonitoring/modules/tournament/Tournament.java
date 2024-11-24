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
}
