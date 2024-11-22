package org.example.hockeymonitoring.modules.match;

import jakarta.persistence.*;
import lombok.Data;
import org.example.hockeymonitoring.modules.matchtype.MatchType;
import org.example.hockeymonitoring.modules.team.Team;

@Data
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "first_team_id")
    private Team firstTeam;

    @ManyToOne
    @JoinColumn(name = "second_team_id")
    private Team secondTeam;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private MatchType type;
}
