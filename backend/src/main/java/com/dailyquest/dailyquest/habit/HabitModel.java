package com.dailyquest.dailyquest.habit;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class HabitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private Integer goalCount; // X amount of times per goalPeriod
    private String goalPeriod;
    private Integer currentStreak;
    private Integer bestStreak;
}
