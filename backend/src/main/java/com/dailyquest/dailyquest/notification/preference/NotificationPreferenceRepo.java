package com.dailyquest.dailyquest.notification.preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationPreferenceRepo extends JpaRepository<NotificationPreferenceModel, Long> {
    @Query("SELECT n FROM NotificationPreferenceModel n WHERE n.userProfile.user.username = :username")
    List<NotificationPreferenceModel> getNotificationPreferenceModelByUsername(@Param("username") String username);
}
