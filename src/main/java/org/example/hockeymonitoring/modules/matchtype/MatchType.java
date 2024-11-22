package org.example.hockeymonitoring.modules.matchtype;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "match_types")
public class MatchType {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
