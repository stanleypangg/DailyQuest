package com.dailyquest.dailyquest.notification.preference;

import com.dailyquest.dailyquest.notification.dto.NotificationPreferenceDTO;
import com.dailyquest.dailyquest.notification.dto.NotificationPreferenceDTOMapper;
import com.dailyquest.dailyquest.notification.exception.NotificationPreferenceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationPreferenceService {

    private final NotificationPreferenceRepo notificationPreferenceRepo;
    private final NotificationPreferenceDTOMapper notificationPreferenceDTOMapper;

    @Autowired
    public NotificationPreferenceService(NotificationPreferenceRepo notificationPreferenceRepo, NotificationPreferenceDTOMapper notificationPreferenceDTOMapper) {
        this.notificationPreferenceRepo = notificationPreferenceRepo;
        this.notificationPreferenceDTOMapper = notificationPreferenceDTOMapper;
    }

    public List<NotificationPreferenceDTO> findAllPreferences(String username) {
        return notificationPreferenceRepo.findByUserProfileUserUsername(username)
                .stream()
                .map(notificationPreferenceDTOMapper)
                .collect(Collectors.toList());
    }

    public NotificationPreferenceDTO findPreferenceById(Long id, String username) {
        NotificationPreferenceModel notificationPreferenceModel =
                notificationPreferenceRepo.findByUserProfileUserUsernameAndId(username, id)
                        .orElseThrow(() -> new NotificationPreferenceNotFoundException(id));
        return notificationPreferenceDTOMapper.apply((notificationPreferenceModel));
    }
}
