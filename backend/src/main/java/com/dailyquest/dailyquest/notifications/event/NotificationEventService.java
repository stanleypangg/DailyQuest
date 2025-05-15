package com.dailyquest.dailyquest.notifications.event;

import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.habit.HabitRepo;
import com.dailyquest.dailyquest.notifications.dto.NotificationEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationEventService {

    private final NotificationEventRepo eventRepo;
    private final HabitRepo habitRepo;

    @Autowired
    public NotificationEventService(NotificationEventRepo eventRepo, HabitRepo habitRepo) {
        this.eventRepo = eventRepo;
        this.habitRepo = habitRepo;
    }

    public NotificationEventModel scheduleNotification(Long habitId) {
        HabitModel habit = habitRepo.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found")); //TODO add custom exception

        NotificationEventModel event = new NotificationEventModel(habit, LocalDateTime.now().plusMinutes(5)); // Example lead time
        return eventRepo.save(event);
    }

    public List<NotificationEventDto> getNotifications(NotificationStatus status) {
        List<NotificationEventModel> events = (status == null)
                ? eventRepo.findAll()
                : eventRepo.findByStatus(status);

        return events.stream()
                .map(event -> new NotificationEventDto(event)) // Convert entity to DTO
                .toList();
    }

}
