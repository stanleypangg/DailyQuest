package com.dailyquest.dailyquest.notification.preference;

import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.notification.dto.settings.NotificationSettingsDTO;
import com.dailyquest.dailyquest.notification.enums.NotificationChannel;
import com.dailyquest.dailyquest.notification.enums.NotificationFrequency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

@Entity
public class NotificationPreferenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Channel: how the user wants to be notified
    @Enumerated(EnumType.STRING)
    @NotNull
    private NotificationChannel channel;
    @Enumerated(EnumType.STRING)
    @NotNull
    private NotificationFrequency frequency;
    private Integer leadTimeMinutes;
    @NotNull
    private boolean enabled = true; // default to true
    // Are these necessary?
    private LocalTime quietHoursStart;
    private LocalTime quietHoursEnd;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "habit_id", nullable = false, updatable = false)
    private HabitModel habit;
    @Transient
    private NotificationSettingsDTO settings;

    public NotificationPreferenceModel() {
    }

    public NotificationPreferenceModel(
            NotificationChannel channel,
            NotificationFrequency frequency,
            Integer leadTimeMinutes,
            boolean enabled,
            HabitModel habit,
            NotificationSettingsDTO settings
    ) {
        this.channel = channel;
        this.frequency = frequency;
        this.leadTimeMinutes = leadTimeMinutes;
        this.enabled = enabled;
        this.habit = habit;
        this.settings = settings;
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

    public NotificationFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(NotificationFrequency frequency) {
        this.frequency = frequency;
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

    public HabitModel getHabit() {
        return habit;
    }

    public void setHabit(HabitModel habit) {
        this.habit = habit;
    }

    public NotificationSettingsDTO getSettings() {
        return settings;
    }

    public void setSettings(NotificationSettingsDTO settings) {
        this.settings = settings;
    }
}
