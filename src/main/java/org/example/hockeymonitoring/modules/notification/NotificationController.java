package org.example.hockeymonitoring.modules.notification;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public void setNotifications() {
        notificationService.sendNotifications();
    }
}
