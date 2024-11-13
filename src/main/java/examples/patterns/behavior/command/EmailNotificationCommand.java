package examples.patterns.behavior.command;

public class EmailNotificationCommand extends NotificationCommand {
    public EmailNotificationCommand(NotificationService notificationService) {
        super(notificationService);
    }

    @Override
    public void execute() {
        notificationService.sendEmailNotification();
    }

    @Override
    public String toString() {
        return "EmailNotificationCommand";
    }
}
