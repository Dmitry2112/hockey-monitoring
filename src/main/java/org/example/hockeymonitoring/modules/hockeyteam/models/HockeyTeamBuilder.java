package org.example.hockeymonitoring.modules.hockeyteam.models;

import org.example.hockeymonitoring.modules.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * Паттерн Builder
 */
public class HockeyTeamBuilder {
    private String name;
    private String description;
    private int trainerId;
    private List<Athlete> players;
    HockeyTeamBuilder() {}
    public HockeyTeamBuilder name(String name) {
        this.name = name;
        return this;
    }
    public HockeyTeamBuilder description(String description) {
        this.description = description;
        return this;
    }
    public HockeyTeamBuilder trainerId(int trainerId) {
        this.trainerId = trainerId;
        return this;
    }
    public HockeyTeamBuilder players(List<Athlete> players) {
        this.players = new ArrayList<>(players);
        return this;
    }
    public HockeyTeam build() {
        return new HockeyTeam(name, description, trainerId, players);
    }
}
