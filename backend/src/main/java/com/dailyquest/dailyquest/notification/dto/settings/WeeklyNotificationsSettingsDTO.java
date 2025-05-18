package com.dailyquest.dailyquest.notification.dto.settings;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record WeeklyNotificationsSettingsDTO(
        DayOfWeek dayOfWeek,
        LocalTime time
) {
}
