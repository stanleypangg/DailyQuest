package com.dailyquest.dailyquest.notifications.event;

public interface NotificationSender {
    void sendNotification(NotificationEventModel event);
}
