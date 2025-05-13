package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.user.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class HabitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "habit_id", nullable = false, updatable = false)
    private UserModel user; // user that this habit belongs too
    @NotBlank
    private String name;
    @NotNull
    private Integer goalCount; // X amount of times per goalPeriod
    @NotBlank
    private String goalPeriod;
    private Integer currentStreak;
    private Integer bestStreak;

    public HabitModel() {
    }

    public HabitModel(UserModel user, String name, Integer goalCount, String goalPeriod) {
        this.user = user;
        this.name = name;
        this.goalCount = goalCount;
        this.goalPeriod = goalPeriod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(Integer goalCount) {
        this.goalCount = goalCount;
    }

    public String getGoalPeriod() {
        return goalPeriod;
    }

    public void setGoalPeriod(String goalPeriod) {
        this.goalPeriod = goalPeriod;
    }

    public Integer getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(Integer currentStreak) {
        this.currentStreak = currentStreak;
    }

    public Integer getBestStreak() {
        return bestStreak;
    }

    public void setBestStreak(Integer bestStreak) {
        this.bestStreak = bestStreak;
    }
}
