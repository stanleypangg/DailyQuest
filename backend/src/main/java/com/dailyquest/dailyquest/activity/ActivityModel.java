package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.habit.HabitModel;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private HabitModel habit;

    public ActivityModel() {
    }

    public ActivityModel(LocalDate logDate, String title, HabitModel habit) {
        this.logDate = logDate;
        this.title = title;
        this.habit = habit;
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

    public HabitModel getHabit() { return habit; }

    public void setHabit(HabitModel habit) { this.habit = habit; }

}
