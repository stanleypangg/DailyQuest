package com.dailyquest.dailyquest.habit.dto;

import com.dailyquest.dailyquest.user.dto.UserDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record HabitDTO(
        @NotNull Long id,
        @NotBlank String name,
        @NotNull @PositiveOrZero Integer goalCount,
        @NotBlank String goalPeriod,
        @NotNull UserDto user
){
}
