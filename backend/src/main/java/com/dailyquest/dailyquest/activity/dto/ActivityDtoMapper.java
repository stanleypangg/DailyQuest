package com.dailyquest.dailyquest.activity.dto;

import com.dailyquest.dailyquest.activity.ActivityModel;
import com.dailyquest.dailyquest.habit.dto.HabitDTO;
import com.dailyquest.dailyquest.habit.dto.HabitDTOMapper;
import com.dailyquest.dailyquest.user.dto.UserDto;
import com.dailyquest.dailyquest.user.dto.UserDtoMapper;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ActivityDtoMapper implements Function<ActivityModel, ActivityDto> {

    private final HabitDTOMapper habitDTOMapper;

    private final UserDtoMapper userDtoMapper;

    public ActivityDtoMapper(HabitDTOMapper habitDTOMapper, UserDtoMapper userDtoMapper) {
        this.habitDTOMapper = habitDTOMapper;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public ActivityDto apply(ActivityModel activity) {
        return new ActivityDto(
                activity.getId(),
                activity.getTitle(),
                activity.getLogDate(),
                habitDTOMapper.apply(activity.getHabit()),
                userDtoMapper.apply(activity.getUser())
        );
    }

}
