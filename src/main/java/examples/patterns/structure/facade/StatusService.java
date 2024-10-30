package examples.patterns.structure.facade;

public class StatusService {
    public boolean checkStatus(HockeyPlayer player) {
        return player.isRegisterStatus();
    }
}
