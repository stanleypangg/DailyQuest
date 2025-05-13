package com.dailyquest.dailyquest.habit.dto;

import com.dailyquest.dailyquest.user.dto.UserDto;

public record HabitDTO(
        Long id,
        String name,
        Integer goalCount,
        String goalPeriod,
        UserDto user
){
}
