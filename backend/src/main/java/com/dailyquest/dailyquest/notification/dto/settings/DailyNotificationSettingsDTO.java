package com.dailyquest.dailyquest.notification.dto.settings;

import java.time.LocalTime;

public record DailyNotificationSettingsDTO(
        LocalTime time
) implements NotificationSettingsDTO {
}
