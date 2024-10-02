package org.example.hockeymonitoring.notification;

public class HockeyPlayerNotification implements Notification {
    private final String message;

    public HockeyPlayerNotification(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format("Информация для игрока: %s", this.message);
    }
}
