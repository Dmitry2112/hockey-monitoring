package examples.patterns.structure.adapter;

public class TeamCaptainService {
    public void influenceTeam(TeamCaptain captain) {
        System.out.println(captain.giveCommand("Быстрее!!! Забивай!!!"));
    }
}
