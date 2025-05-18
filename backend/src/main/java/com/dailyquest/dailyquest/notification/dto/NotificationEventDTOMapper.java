package com.dailyquest.dailyquest.notification.dto;

import com.dailyquest.dailyquest.habit.dto.HabitDTOMapper;
import com.dailyquest.dailyquest.notification.event.NotificationEventModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class NotificationEventDTOMapper implements Function<NotificationEventModel, NotificationEventDTO> {

    private final HabitDTOMapper habitDTOMapper;

    public NotificationEventDTOMapper (HabitDTOMapper habitDTOMapper) {
        this.habitDTOMapper = habitDTOMapper;
    }

    public NotificationEventDTO apply(NotificationEventModel notification) {
        return new NotificationEventDTO(
                notification.getId(),
                habitDTOMapper.apply(notification.getHabit()),
                notification.getScheduledTime(),
                notification.getSentTime(),
                notification.getStatus().name()
        );
    }



}
