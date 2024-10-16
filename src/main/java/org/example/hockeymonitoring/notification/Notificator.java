package org.example.hockeymonitoring.notification;

/**
 * Паттерн Factory method
 */
public abstract class Notificator {
    protected abstract Notification createNotification();

    void sendNotification() {
        Notification notification = createNotification();
        System.out.println(notification.getMessage());
    }
}