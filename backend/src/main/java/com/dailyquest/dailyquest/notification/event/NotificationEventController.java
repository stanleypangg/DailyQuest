package com.dailyquest.dailyquest.notification.event;

import com.dailyquest.dailyquest.notification.dto.CreateNoficationEventDTO;
import com.dailyquest.dailyquest.notification.dto.NotificationEventDTOMapper;
import com.dailyquest.dailyquest.notification.dto.NotificationEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationEventController {

    private final NotificationEventService notificationService;
    private final NotificationEventDTOMapper notificationEventDTOMapper;

    @Autowired
    public NotificationEventController(NotificationEventService notificationService, NotificationEventDTOMapper notificationEventDTOMapper) {
        this.notificationService = notificationService;
        this.notificationEventDTOMapper = notificationEventDTOMapper;
    }

    // 🔹 Get all notifications (optional: filter by status)
    @GetMapping
    public List<NotificationEventDTO> getAllNotifications(@RequestParam(required = false) NotificationStatus status) {
        return notificationService.getNotifications(status);
    }

    @PostMapping("/send")
    public ResponseEntity<NotificationEventDTO> createNotificationEvent(@RequestBody CreateNoficationEventDTO requestDto) {
        NotificationEventDTO event = notificationService.scheduleNotification(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

}
