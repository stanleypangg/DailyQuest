package com.dailyquest.dailyquest.activity.dto;

import java.time.LocalDate;

public class ActivityDTO {

    private String title;
    private LocalDate logDate;
    private Long habitId; // Only referencing the habit ID

    // Default constructor
    public ActivityDTO() {}

    // Constructor with fields
    public ActivityDTO(String title, LocalDate logDate, Long habitId) {
        this.title = title;
        this.logDate = logDate;
        this.habitId = habitId;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getLogDate() { return logDate; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }

    public Long getHabitId() { return habitId; }
    public void setHabitId(Long habitId) { this.habitId = habitId; }
}
