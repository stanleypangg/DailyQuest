package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.notification.preference.NotificationChannel;
import com.dailyquest.dailyquest.notification.preference.NotificationFrequency;

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
