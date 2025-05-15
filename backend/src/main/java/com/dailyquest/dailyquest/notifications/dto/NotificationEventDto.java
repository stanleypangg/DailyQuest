package com.dailyquest.dailyquest.notifications.dto;

import com.dailyquest.dailyquest.notifications.NotificationEventModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record NotificationEventDto(
        Long id,
        String habitName,
        LocalDateTime scheduledTime,
        LocalDateTime sentTime,
        String status
) {
    public NotificationEventDto(NotificationEventModel event) {
        this(event.getId(),
                event.getHabit().getName(),
                event.getScheduledTime(),
                event.getSentTime(),
                event.getStatus().name());
    }

}
