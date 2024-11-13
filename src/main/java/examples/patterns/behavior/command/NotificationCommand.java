package examples.patterns.behavior.command;

/**
 * Паттерн Command
 */
public abstract class NotificationCommand {
    protected final NotificationService notificationService;

    protected NotificationCommand(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public abstract void execute();
}
