package com.dailyquest.dailyquest.notification.event;

import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.habit.HabitRepo;
import com.dailyquest.dailyquest.notification.dto.CreateNoficationEventDTO;
import com.dailyquest.dailyquest.notification.dto.NotificationEventDTOMapper;
import com.dailyquest.dailyquest.notification.dto.NotificationEventDTO;
import com.dailyquest.dailyquest.notification.enums.NotificationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationEventService {

    private final NotificationEventRepo eventRepo;
    private final HabitRepo habitRepo;
    private final NotificationEventDTOMapper notificationEventDTOMapper;

    @Autowired
    public NotificationEventService(NotificationEventRepo eventRepo, HabitRepo habitRepo, NotificationEventDTOMapper notificationEventDTOMapper) {
        this.eventRepo = eventRepo;
        this.habitRepo = habitRepo;
        this.notificationEventDTOMapper = notificationEventDTOMapper;
    }

    public NotificationEventDTO scheduleNotification(CreateNoficationEventDTO request) {
        HabitModel habit = habitRepo.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Habit not found")); //TODO add custom exception

        NotificationEventModel event = new NotificationEventModel(habit, request.scheduledTime()); // Example lead time
        eventRepo.save(event);

        return notificationEventDTOMapper.apply(event);
    }

    public List<NotificationEventDTO> getNotifications(NotificationStatus status) {
        List<NotificationEventModel> events = (status == null)
                ? eventRepo.findAll()
                : eventRepo.findByStatus(status);

        return events.stream()
                .map(notificationEventDTOMapper)// Convert entity to DTO
                .toList();
    }

}
