package com.dailyquest.dailyquest.notifications.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationScheduler {

    private final NotificationEventRepo eventRepo;
    private final NotificationSender notificationSender;

    @Autowired
    public NotificationScheduler(NotificationEventRepo eventRepo, NotificationSender notificationSender) {
        this.eventRepo = eventRepo;
        this.notificationSender = notificationSender;
    }

    @Scheduled(fixedRate = 60000) // Runs every minute
    public void processPendingNotifications() {
        List<NotificationEventModel> pendingEvents = eventRepo.findByStatus(NotificationStatus.PENDING);

        for (NotificationEventModel event : pendingEvents) {
            notificationSender.sendNotification(event);
            event.markAsSent();
            eventRepo.save(event);
        }
    }
}
