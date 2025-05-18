package com.dailyquest.dailyquest.notification.preference;

import com.dailyquest.dailyquest.notification.dto.CreateNotificationPreferenceDTO;
import com.dailyquest.dailyquest.notification.dto.NotificationPreferenceDTO;
import com.dailyquest.dailyquest.notification.dto.NotificationPreferenceDTOMapper;
import com.dailyquest.dailyquest.notification.exception.NotificationPreferenceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationPreferenceService {

    private final NotificationPreferenceRepo notificationPreferenceRepo;
    private final NotificationPreferenceDTOMapper notificationPreferenceDTOMapper;
    private ObjectMapper objectMapper;

    @Autowired
    public NotificationPreferenceService(
            NotificationPreferenceRepo notificationPreferenceRepo,
            NotificationPreferenceDTOMapper notificationPreferenceDTOMapper
    ) {
        this.notificationPreferenceRepo = notificationPreferenceRepo;
        this.notificationPreferenceDTOMapper = notificationPreferenceDTOMapper;
    }

    public List<NotificationPreferenceDTO> findAllPreferences(String username) {
        return notificationPreferenceRepo.findByHabitUserUsername(username)
                .stream()
                .map(notificationPreferenceDTOMapper)
                .collect(Collectors.toList());
    }

    public NotificationPreferenceDTO findPreferenceById(Long id, String username) {
        NotificationPreferenceModel notificationPreferenceModel =
                notificationPreferenceRepo.findByHabitUserUsernameAndId(username, id)
                        .orElseThrow(() -> new NotificationPreferenceNotFoundException(id));
        return notificationPreferenceDTOMapper.apply((notificationPreferenceModel));
    }

    public NotificationPreferenceDTO createPreference(
            CreateNotificationPreferenceDTO request,
            Object settings
    ) {
        try {
            if (settings != null) {
                String settingsJson = objectMapper.writeValueAsString(settings);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error serializing to JSON " + e);
        }
        // TODO: fix this up
        return null;
    }

    public void deletePreference(long id, String username) {
        if (notificationPreferenceRepo.deleteByHabitUserUsernameAndId(username, id) == 0) {
            throw new NotificationPreferenceNotFoundException(id);
        }
    }
}
