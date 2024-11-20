package org.example.hockeymonitoring.modules.team;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private int missedGoals;

    private int scoredGoals;
}
