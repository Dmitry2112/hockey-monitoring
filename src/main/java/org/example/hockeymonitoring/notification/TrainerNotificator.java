package org.example.hockeymonitoring.notification;

public class TrainerNotificator extends Notificator {
    @Override
    protected TrainerNotification createNotification() {
        return new TrainerNotification("Найдите свою команду в зале");
    }
}
