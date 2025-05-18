package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.habit.dto.HabitDTO;

import java.time.LocalDateTime;

public record NotificationEventDTO(
        Long id,
        HabitDTO habit,
        LocalDateTime scheduledTime,
        LocalDateTime sentTime,
        String status
) {

}
