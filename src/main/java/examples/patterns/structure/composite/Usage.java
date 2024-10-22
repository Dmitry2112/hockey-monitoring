package examples.patterns.structure.composite;

public class Usage {
    public static void main(String[] args) {
        HockeyTeam team = createHockeyTeam();
        team.registerOnGame();
    }

    private static HockeyTeam createHockeyTeam() {
        HockeyTeam sparePlayers = new HockeyTeam();
        sparePlayers.addHockeyStructureElement(new HockeyPlayer());
        sparePlayers.addHockeyStructureElement(new HockeyPlayer());

        HockeyTeam mainPlayers = new HockeyTeam();
        mainPlayers.addHockeyStructureElement(new HockeyPlayer());
        mainPlayers.addHockeyStructureElement(new HockeyPlayer());
        mainPlayers.addHockeyStructureElement(new HockeyPlayer());
        mainPlayers.addHockeyStructureElement(new HockeyPlayer());
        mainPlayers.addHockeyStructureElement(new HockeyPlayer());

        HockeyTeam team = new HockeyTeam();
        team.addHockeyStructureElement(sparePlayers);
        team.addHockeyStructureElement(mainPlayers);

        return team;
    }
}
