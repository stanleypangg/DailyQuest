package com.dailyquest.dailyquest.habit.dto;

import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.user.dto.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HabitDTOMapper implements Function<HabitModel, HabitDTO> {

    private final UserDtoMapper userDtoMapper;

    @Autowired
    public HabitDTOMapper(UserDtoMapper userDtoMapper) {
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public HabitDTO apply(HabitModel habit) {
        return new HabitDTO(
                habit.getId(),
                habit.getName(),
                habit.getGoalCount(),
                habit.getGoalPeriod(),
                userDtoMapper.apply(habit.getUser())
        );
    }
}
