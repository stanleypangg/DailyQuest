package com.dailyquest.dailyquest.habit.dto;

import com.dailyquest.dailyquest.habit.HabitModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HabitDTOMapper implements Function<HabitModel, HabitDTO> {

    @Override
    public HabitDTO apply(HabitModel habit) {
        return new HabitDTO(
                habit.getId(),
                habit.getName()
        );
    }
}
