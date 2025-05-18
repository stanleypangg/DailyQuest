package com.dailyquest.dailyquest.notification.dto.settings;

import java.time.LocalTime;

public record HourlyNotificationSettingsDTO(
        LocalTime startTime,
        LocalTime endTime,
        Integer interval,
        Integer randomizationWindow
) implements NotificationSettingsDTO {
}
