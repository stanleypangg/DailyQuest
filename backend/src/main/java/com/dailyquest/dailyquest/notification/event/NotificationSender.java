package com.dailyquest.dailyquest.notification.event;

public interface NotificationSender {
    void sendNotification(NotificationEventModel event);
}
