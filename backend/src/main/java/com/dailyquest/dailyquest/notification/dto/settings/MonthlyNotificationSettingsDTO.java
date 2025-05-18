package com.dailyquest.dailyquest.notification.dto.settings;

import java.time.LocalTime;

public record MonthlyNotificationSettingsDTO(
        Integer dayOfMonth,
        LocalTime time
) {
}
