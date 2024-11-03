package org.example.hockeymonitoring.modules.notification;

public class HockeyPlayerNotificator extends Notificator {
    @Override
    protected HockeyPlayerNotification createNotification() {
        return new HockeyPlayerNotification("Найдите своего тренера в зале");
    }
}
