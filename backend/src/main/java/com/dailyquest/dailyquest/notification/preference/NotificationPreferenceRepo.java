package com.dailyquest.dailyquest.notification.preference;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationPreferenceRepo extends JpaRepository<NotificationPreferenceModel, Long> {
    List<NotificationPreferenceModel> findByHabitUserUsername(String username);
    Optional<NotificationPreferenceModel> findByHabitUserUsernameAndId(String username, Long id);
    long deleteByHabitUserUsernameAndId(String username, Long id);
}
