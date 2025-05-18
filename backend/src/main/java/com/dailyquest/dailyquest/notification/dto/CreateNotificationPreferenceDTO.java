package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.notification.enums.NotificationChannel;
import com.dailyquest.dailyquest.notification.enums.NotificationFrequency;

public record CreateNotificationPreferenceDTO(
        NotificationChannel notificationChannel,
        NotificationFrequency notificationFrequency
) {
}
