package examples.patterns.structure.facade;

public class HockeyTeamService {
    public boolean checkTeam(HockeyPlayer player) {
        return player.isTeamExist();
    }
}
