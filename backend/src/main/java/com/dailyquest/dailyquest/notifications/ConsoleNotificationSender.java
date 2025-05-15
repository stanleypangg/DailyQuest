package com.dailyquest.dailyquest.notifications;

import org.springframework.stereotype.Service;

@Service
public class ConsoleNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(NotificationEventModel event) {
        System.out.println("Notification sent for habit: " + event.getHabit().getName());
    }
}
