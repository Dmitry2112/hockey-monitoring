package examples.patterns.behavior.chainofresponsibility;

public class ChangeTeamNameHandler extends HandlerBase<Athlete> {
    private final String newTeamName;
    private final boolean terminal;

    public ChangeTeamNameHandler(String newTeamName, boolean terminal) {
        this.newTeamName = newTeamName;
        this.terminal = terminal;
    }

    @Override
    protected boolean doHandle(Athlete context) {
        System.out.printf("Изменение команды игрока: %s%n", context.getName());
        System.out.printf("Старая команда: %s%n", context.getTeamName());
        context.setTeamName(newTeamName);
        System.out.printf("Новая команда: %s%n", context.getTeamName());
        return !terminal;
    }
}
