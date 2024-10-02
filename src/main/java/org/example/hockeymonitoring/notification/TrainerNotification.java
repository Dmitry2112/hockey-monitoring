package org.example.hockeymonitoring.notification;

public class TrainerNotification implements Notification {
    private final String message;

    public TrainerNotification(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format("Информация для тренера: %s", this.message);
    }
}
