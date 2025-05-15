package com.dailyquest.dailyquest.notification.preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface NotificationPreferenceRepo extends JpaRepository<NotificationPreferenceModel, Long> {
    List<NotificationPreferenceModel> findByUserProfileUserUsername(String username);
    Optional<NotificationPreferenceModel> findByUserProfileUsernameAndId(String username, Long id);
}
