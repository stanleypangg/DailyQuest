package com.dailyquest.dailyquest.notification.dto;

import java.time.LocalDateTime;

public record CreateNoficationEventDTO (
        Long id,
        LocalDateTime scheduledTime,
        String status
) {

}
