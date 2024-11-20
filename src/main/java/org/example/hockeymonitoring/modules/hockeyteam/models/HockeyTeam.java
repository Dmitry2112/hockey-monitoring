package org.example.hockeymonitoring.modules.hockeyteam.models;

import lombok.Data;
import org.example.hockeymonitoring.modules.athlete.Athlete;

import java.util.List;

@Data
public class HockeyTeam {
    private String name;
    private String description;
    private long trainerId;
    private List<Athlete> players;
    HockeyTeam(String name, String description, int trainerId, List<Athlete> players) {
        this.name = name;
        this.description = description;
        this.trainerId = trainerId;
        this.players = players;
    }
    public static HockeyTeamBuilder builder() {
        return new HockeyTeamBuilder();
    }
    public String sayTeamChant() {
        return String.format("%s - лучше всех! %s ждет успех!", this.name, this.name);
    }
}
