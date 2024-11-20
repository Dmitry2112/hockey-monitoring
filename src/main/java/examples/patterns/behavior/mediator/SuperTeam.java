package examples.patterns.behavior.mediator;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Паттерн Mediator
 */
public class SuperTeam implements Team {
    @Setter
    private TeamMember teamCaptain;
    private final List<TeamMember> players = new ArrayList<>();

    public void addPlayer(TeamMember player) {
        players.add(player);
    }

    @Override
    public void sendMessage(String message, TeamMember teamMember) {
        for (TeamMember player : players) {
            if (!player.equals(teamMember)) {
                player.getMessage(message);
            }
        }
        teamCaptain.getMessage(message);
    }
}
