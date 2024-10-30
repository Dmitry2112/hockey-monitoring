package examples.patterns.structure.facade;

import lombok.Getter;

@Getter
public class HockeyPlayer {
    private final String name;
    private boolean isRegisterStatus;
    private boolean teamExist;

    public HockeyPlayer(String name) {
        this.name = name;
    }

    public void changeIsRegister(boolean newStatus) {
        isRegisterStatus = newStatus;
    }

    public void changeTeamIsExist(boolean newStatus) {
        teamExist = newStatus;
    }
}
