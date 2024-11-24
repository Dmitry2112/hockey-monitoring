package org.example.hockeymonitoring.modules.tournamenttype;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tournament_types")
public class TournamentType {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
