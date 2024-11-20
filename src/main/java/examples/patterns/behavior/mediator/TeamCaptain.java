package examples.patterns.behavior.mediator;

public class TeamCaptain implements TeamMember {
    private final Team team;
    private final String name;

    public TeamCaptain(Team team, String name) {
        this.team = team;
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        team.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.printf("Капитан команды %s получает сообщение: %s\n", name, message);
    }
}
