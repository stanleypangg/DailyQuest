package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.notification.enums.NotificationChannel;
import com.dailyquest.dailyquest.notification.enums.NotificationFrequency;

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
