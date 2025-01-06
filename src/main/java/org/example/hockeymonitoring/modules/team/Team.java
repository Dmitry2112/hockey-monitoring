package org.example.hockeymonitoring.modules.team;

import jakarta.persistence.*;
import lombok.Data;
import org.example.hockeymonitoring.modules.athlete.Athlete;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String gender;

    @ManyToMany
    @JoinTable(name = "teams_athletes",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "athletes_id"))
    private Set<Athlete> athletes = new LinkedHashSet<>();
}
