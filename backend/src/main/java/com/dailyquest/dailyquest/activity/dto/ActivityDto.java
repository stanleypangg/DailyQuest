package com.dailyquest.dailyquest.activity.dto;

import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import com.dailyquest.dailyquest.user.dto.UserDto;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ActivityDto(
        Long id,
        String title,
        @PastOrPresent LocalDate logDate,
        HabitDTO habit,
        UserDto user) {
}
