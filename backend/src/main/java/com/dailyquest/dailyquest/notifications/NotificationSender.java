package com.dailyquest.dailyquest.notifications;

public interface NotificationSender {
    void sendNotification(NotificationEventModel event);
}
