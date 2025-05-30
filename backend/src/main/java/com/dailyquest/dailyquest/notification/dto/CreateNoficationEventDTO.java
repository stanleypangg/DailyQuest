package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.notification.enums.NotificationStatus;

import java.time.LocalDateTime;

public record CreateNoficationEventDTO (
        Long id,
        LocalDateTime scheduledTime,
        LocalDateTime sentTime,
        NotificationStatus status
) {

}
