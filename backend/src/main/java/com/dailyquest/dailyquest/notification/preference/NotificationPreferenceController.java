package com.dailyquest.dailyquest.notification.preference;

import com.dailyquest.dailyquest.notification.dto.NotificationPreferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/me/notifications")
public class NotificationPreferenceController {

    private final NotificationPreferenceService notificationPreferenceService;

    @Autowired
    public NotificationPreferenceController(NotificationPreferenceService notificationPreferenceService) {
        this.notificationPreferenceService = notificationPreferenceService;
    }

    @GetMapping
    public List<NotificationPreferenceDTO> findAllPreferences(@AuthenticationPrincipal UserDetails userDetails) {
        return notificationPreferenceService.findAllPreferences(userDetails.getUsername());
    }

    @GetMapping("/{id}")
    public NotificationPreferenceDTO findPreferenceById(
            @PathVariable("id") Long id,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return notificationPreferenceService.findPreferenceById(id, userDetails.getUsername());
    }
}
