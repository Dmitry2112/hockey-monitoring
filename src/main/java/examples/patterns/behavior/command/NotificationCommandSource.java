package examples.patterns.behavior.command;

public class NotificationCommandSource {
    private final NotificationCommand command;

    public NotificationCommandSource(NotificationCommand command) {
        this.command = command;
    }

    public void use() {
        command.execute();
    }
}
