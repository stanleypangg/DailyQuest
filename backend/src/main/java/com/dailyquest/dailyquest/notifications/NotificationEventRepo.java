package com.dailyquest.dailyquest.notifications;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationEventRepo extends JpaRepository<NotificationEventModel, Long> {
    List<NotificationEventModel> findByStatus (NotificationStatus status);
}
