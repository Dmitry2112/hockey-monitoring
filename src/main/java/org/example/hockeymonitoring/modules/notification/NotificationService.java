package org.example.hockeymonitoring.modules.notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotifications() {
        Notificator notificator;

        notificator = new HockeyPlayerNotificator();
        notificator.sendNotification();

        notificator = new TrainerNotificator();
        notificator.sendNotification();
    }
}
