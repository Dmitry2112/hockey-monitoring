package examples.patterns.behavior.strategy;

public class HockeyPlayer {
    private final String name;
    private final TeamRole teamRole;

    public HockeyPlayer(String name, TeamRole teamRole) {
        this.name = name;
        this.teamRole = teamRole;
    }

    public void play() {
        System.out.println(name);
        teamRole.play();
    }
}
