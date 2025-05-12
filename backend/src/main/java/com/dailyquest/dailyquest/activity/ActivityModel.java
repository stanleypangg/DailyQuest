package com.dailyquest.dailyquest.activity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class ActivityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private LocalDate logDate;

    private Integer habitId;

    public ActivityModel() {
    }

    public ActivityModel(LocalDate logDate, String title, Integer habitId) {
        this.logDate = logDate;
        this.title = title;
        this.habitId = habitId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public Integer getHabitId() { return habitId; }

    public void setHabitId(Integer habitId) { this.habitId = habitId; }
}
