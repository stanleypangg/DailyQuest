package com.dailyquest.dailyquest.notification.event;

import com.dailyquest.dailyquest.habit.HabitModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class NotificationEventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private HabitModel habit;

    private LocalDateTime scheduledTime;
    private LocalDateTime sentTime;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    public HabitModel getHabit() {
        return habit;
    }

    public void setHabit(HabitModel habit) {
        this.habit = habit;
    }

    public NotificationEventModel() {}

    public NotificationEventModel(HabitModel habit, LocalDateTime scheduledTime) {
        this.habit = habit;
        this.scheduledTime = scheduledTime;
        this.status = NotificationStatus.PENDING; // Default status
    }

    public void markAsSent() {
        this.sentTime = LocalDateTime.now();
        this.status = NotificationStatus.SENT;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public NotificationStatus getStatus() {
        return status;
    }

}
