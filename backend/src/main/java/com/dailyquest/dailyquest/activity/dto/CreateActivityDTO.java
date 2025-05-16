package com.dailyquest.dailyquest.activity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record CreateActivityDTO(
        @NotBlank String title,
        @PastOrPresent LocalDate logDate,
        @NotNull Long habitId
) {
}
