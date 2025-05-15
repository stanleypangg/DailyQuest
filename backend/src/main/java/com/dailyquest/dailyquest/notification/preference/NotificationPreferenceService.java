package com.dailyquest.dailyquest.notification.preference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationPreferenceService {

    private final NotificationPreferenceRepo notificationPreferenceRepo;

    @Autowired
    public NotificationPreferenceService(NotificationPreferenceRepo notificationPreferenceRepo) {
        this.notificationPreferenceRepo = notificationPreferenceRepo;
    }

    public List<NotificationPreferenceModel> findAllPreferences(String username) {}
}
