package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.notification.dto.settings.NotificationSettingsDTO;
import com.dailyquest.dailyquest.notification.enums.NotificationChannel;
import com.dailyquest.dailyquest.notification.enums.NotificationFrequency;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record CreateNotificationPreferenceDTO(
        @NotNull NotificationChannel notificationChannel,
        @NotNull NotificationFrequency notificationFrequency,
        Integer leadTimeMinutes,
        LocalTime quietHoursStart,
        LocalTime quietHoursEnd,
        @NotNull NotificationSettingsDTO settings
) {
}
