package com.dailyquest.dailyquest.habit;

import com.dailyquest.dailyquest.userprofile.UserProfileModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
}
