package com.dailyquest.dailyquest.notification.preference;

import com.dailyquest.dailyquest.notification.dto.CreateNotificationPreferenceDTO;
import com.dailyquest.dailyquest.notification.dto.NotificationPreferenceDTO;
import com.dailyquest.dailyquest.notification.dto.UpdateNotificationPreferenceDTO;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<NotificationPreferenceDTO> createPreference(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody CreateNotificationPreferenceDTO request
    ) {
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<NotificationPreferenceDTO> updatePreference(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody UpdateNotificationPreferenceDTO request,
            @PathParam("id") Long id
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreference(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathParam("id") Long id
    ) {
        return ResponseEntity.ok().build();
    }
}
