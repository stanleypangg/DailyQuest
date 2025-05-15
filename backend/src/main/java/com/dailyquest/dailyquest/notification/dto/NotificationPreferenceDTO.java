package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.notification.NotificationChannel;
import com.dailyquest.dailyquest.notification.NotificationFrequency;

import java.time.LocalTime;

public record NotificationPreferenceDTO(
        Long id,
        NotificationChannel channel,
        NotificationFrequency frequency,
        Integer leadTimeMinutes,
        LocalTime quietHoursStart,
        LocalTime quietHoursEnd,
        boolean enabled
) {
}
