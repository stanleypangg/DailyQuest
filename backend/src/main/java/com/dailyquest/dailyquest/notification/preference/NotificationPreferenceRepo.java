package com.dailyquest.dailyquest.notification.preference;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationPreferenceRepo extends JpaRepository<NotificationPreferenceModel, Long> {
    List<NotificationPreferenceModel> findByUserProfileUserUsername(String username);
    Optional<NotificationPreferenceModel> findByUserProfileUserUsernameAndId(String username, Long id);
}
