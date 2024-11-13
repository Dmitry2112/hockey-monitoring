package examples.patterns.behavior.command;

import java.util.List;

public class Usage {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        NotificationCommandSource emailSource = new NotificationCommandSource(new EmailNotificationCommand(notificationService));
        NotificationCommandSource smsSource = new NotificationCommandSource(new SmsNotificationCommand(notificationService));

        emailSource.use();
        smsSource.use();

        showHistory(notificationService.getNotificationHistory());
    }

    private static void showHistory(List<NotificationCommand> history) {
        System.out.println("\nИстория отправленных сообщений:\n");
        history.forEach(x -> System.out.println(x.toString()));
    }
}
