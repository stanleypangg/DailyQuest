package com.dailyquest.dailyquest.activity.dto;

import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import com.dailyquest.dailyquest.user.dto.UserDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ActivityDto(
        @NotNull Long id,
        @NotBlank String title,
        @PastOrPresent LocalDate logDate,
        @NotNull HabitDTO habit,
        @NotNull UserDto user) {
}
