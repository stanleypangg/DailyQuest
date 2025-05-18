package com.dailyquest.dailyquest.habit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateHabitDTO(
        @NotBlank String name,
        @NotNull Integer goalCount,
        @NotBlank String goalPeriod
) {
}
