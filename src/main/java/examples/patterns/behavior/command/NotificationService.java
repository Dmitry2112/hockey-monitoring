package examples.patterns.behavior.command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NotificationService {
    private final List<NotificationCommand> notificationHistory = new ArrayList<>();

    public void sendEmailNotification() {
        System.out.println("Сообщение отправлено по почте");
        notificationHistory.add(new EmailNotificationCommand(this));
    }

    public void sendSmsNotification() {
        System.out.println("Сообщение отправлено по sms");
        notificationHistory.add(new SmsNotificationCommand(this));
    }
}
