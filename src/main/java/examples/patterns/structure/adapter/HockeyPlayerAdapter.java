package examples.patterns.structure.adapter;

/**
 * Паттерн Adapter
 */
public class HockeyPlayerAdapter implements TeamCaptain {
    private final HockeyPlayer hockeyPlayer;

    public HockeyPlayerAdapter(HockeyPlayer hockeyPlayer) {
        this.hockeyPlayer = hockeyPlayer;
    }

    @Override
    public String giveCommand(String command) {
        return hockeyPlayer.saySomething(command);
    }
}
