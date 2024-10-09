package examples.patterns.structure.adapter;

public class Usage {
    public static void main(String[] args) {
        TeamCaptainService teamCaptainService = new TeamCaptainService();
        HockeyPlayer hockeyPlayer = new HockeyPlayer();

        teamCaptainService.influenceTeam(new HockeyPlayerAdapter(hockeyPlayer));
    }
}
