package com.dailyquest.dailyquest.notification;

import com.dailyquest.dailyquest.userprofile.UserProfileModel;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class NotificationPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Channel: how the user wants to be notified
    @Enumerated(EnumType.STRING)
    private NotificationChannel channel;
    private Integer leadTimeMinutes;
    private boolean enabled;
    private LocalTime quietHoursStart;
    private LocalTime quietHoursEnd;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_profile_id", nullable = false, updatable = false)
    private UserProfileModel userProfile;

    public NotificationPreference() {
    }

    public NotificationPreference(NotificationChannel channel, Integer leadTimeMinutes, boolean enabled, LocalTime quietHoursStart, LocalTime quietHoursEnd, UserProfileModel userProfile) {
        this.channel = channel;
        this.leadTimeMinutes = leadTimeMinutes;
        this.enabled = enabled;
        this.quietHoursStart = quietHoursStart;
        this.quietHoursEnd = quietHoursEnd;
        this.userProfile = userProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public Integer getLeadTimeMinutes() {
        return leadTimeMinutes;
    }

    public void setLeadTimeMinutes(Integer leadTimeMinutes) {
        this.leadTimeMinutes = leadTimeMinutes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalTime getQuietHoursStart() {
        return quietHoursStart;
    }

    public void setQuietHoursStart(LocalTime quietHoursStart) {
        this.quietHoursStart = quietHoursStart;
    }

    public LocalTime getQuietHoursEnd() {
        return quietHoursEnd;
    }

    public void setQuietHoursEnd(LocalTime quietHoursEnd) {
        this.quietHoursEnd = quietHoursEnd;
    }

    public UserProfileModel getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileModel userProfile) {
        this.userProfile = userProfile;
    }
}
