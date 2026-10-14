package com.example.playlist;

public class UserProfile {

    private NotificationService notificationService;

// Setter -autowiring byType
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification() {
        notificationService.sendNotification();
    }
}
