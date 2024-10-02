package org.example.hockeymonitoring.hockeyteam.models;

import lombok.Data;
import org.example.hockeymonitoring.hockeyplayer.models.HockeyPlayer;

import java.util.List;

@Data
public class HockeyTeam {
    private String name;
    private String description;
    private long trainerId;
    private List<HockeyPlayer> players;
    HockeyTeam(String name, String description, int trainerId, List<HockeyPlayer> players) {
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
