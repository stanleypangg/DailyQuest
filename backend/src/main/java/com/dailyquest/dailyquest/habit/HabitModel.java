package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.userprofile.UserProfileModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class HabitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private UserProfileModel user; // user that this habit belongs too
    @NotBlank
    private String name;
    private Integer goalCount; // X amount of times per goalPeriod
    private String goalPeriod;
    private Integer currentStreak;
    private Integer bestStreak;

    public HabitModel() {
    }


    public HabitModel(UserProfileModel user, String name, Integer goalCount, String goalPeriod, Integer currentStreak, Integer bestStreak) {
        this.user = user;
        this.name = name;
        this.goalCount = goalCount;
        this.goalPeriod = goalPeriod;
        this.currentStreak = currentStreak;
        this.bestStreak = bestStreak;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfileModel getUser() {
        return user;
    }

    public void setUser(UserProfileModel user) {
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
