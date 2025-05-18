package com.dailyquest.dailyquest.activity.dto;

import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateActivityDTO(
        String title,
        @PastOrPresent LocalDate logDate
//        HabitDTO habit
) {
}
