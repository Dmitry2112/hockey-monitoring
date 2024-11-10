package org.example.hockeymonitoring.modules.teamrole.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "team_roles")
public class TeamRole {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
