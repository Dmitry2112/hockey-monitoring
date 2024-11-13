package examples.patterns.behavior.command;

public class SmsNotificationCommand extends NotificationCommand {
    public SmsNotificationCommand(NotificationService notificationService) {
        super(notificationService);
    }

    @Override
    public void execute() {
        notificationService.sendSmsNotification();
    }

    @Override
    public String toString() {
        return "SmsNotificationCommand";
    }
}
