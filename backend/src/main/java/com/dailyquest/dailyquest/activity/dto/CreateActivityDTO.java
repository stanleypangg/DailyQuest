package com.dailyquest.dailyquest.activity.dto;

import java.time.LocalDate;

public record CreateActivityDTO(String title, LocalDate logDate, Long habitId) {
}
