package com.dailyquest.dailyquest.notification.preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface NotificationPreferenceRepo extends JpaRepository<NotificationPreferenceModel, Long> {
}
