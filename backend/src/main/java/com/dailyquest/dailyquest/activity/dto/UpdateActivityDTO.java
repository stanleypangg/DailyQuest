package com.dailyquest.dailyquest.activity.dto;

import com.dailyquest.dailyquest.habit.dto.HabitDTO;

import java.time.LocalDate;

public record UpdateActivityDTO(
        String title,
        LocalDate logDate
//        HabitDTO habit
) {
}
