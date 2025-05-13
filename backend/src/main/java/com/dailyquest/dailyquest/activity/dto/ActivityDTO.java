package com.dailyquest.dailyquest.activity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ActivityDTO {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "Log date must be provided")
    private LocalDate logDate;

    @NotNull(message = "Habit id must be provided")
    private Long habitId; // Only referencing the habit ID

    public ActivityDTO() {}

    public ActivityDTO(String title, LocalDate logDate, Long habitId) {
        this.title = title;
        this.logDate = logDate;
        this.habitId = habitId;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getLogDate() { return logDate; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }

    public Long getHabitId() { return habitId; }
    public void setHabitId(Long habitId) { this.habitId = habitId; }
}
