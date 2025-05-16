package com.dailyquest.dailyquest.notification.event;

import com.dailyquest.dailyquest.notification.dto.NotificationEventDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationEventController {

    private final NotificationEventService notificationService;

    @Autowired
    public NotificationEventController(NotificationEventService notificationService) {
        this.notificationService = notificationService;
    }

    // 🔹 Get all notifications (optional: filter by status)
    @GetMapping
    public List<NotificationEventDto> getAllNotifications(@RequestParam(required = false) NotificationStatus status) {
        return notificationService.getNotifications(status);
    }

    @PostMapping("/{habitId}")
    public ResponseEntity<NotificationEventDto> createNotificationEvent(@PathVariable Long habitId) {
        NotificationEventModel event = notificationService.scheduleNotification(habitId);
        NotificationEventDto eventDto = new NotificationEventDto(event); // Convert model to DTO
        return ResponseEntity.status(HttpStatus.CREATED).body(eventDto);
    }

}
