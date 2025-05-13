package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.user.UserModel;
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "habit_id", nullable = false, updatable = false)
    private HabitModel habit;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserModel user;

    public ActivityModel() {
    }

    public ActivityModel(LocalDate logDate, String title, HabitModel habit, UserModel user) {
        this.logDate = logDate;
        this.title = title;
        this.habit = habit;
        this.user = user;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
