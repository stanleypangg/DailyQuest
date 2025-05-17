package com.dailyquest.dailyquest.activity;

import com.dailyquest.dailyquest.activity.dto.ActivityDto;
import com.dailyquest.dailyquest.activity.dto.ActivityDtoMapper;
import com.dailyquest.dailyquest.activity.dto.CreateActivityDTO;
import com.dailyquest.dailyquest.activity.dto.UpdateActivityDTO;
import com.dailyquest.dailyquest.activity.exception.ActivityDoesNotExistException;
import com.dailyquest.dailyquest.activity.exception.HabitNotFoundException;
import com.dailyquest.dailyquest.activity.exception.UserNotFoundException;
import com.dailyquest.dailyquest.habit.HabitModel;
import com.dailyquest.dailyquest.habit.HabitRepo;
import com.dailyquest.dailyquest.user.UserModel;
import com.dailyquest.dailyquest.user.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepo activityRepo;
    private final HabitRepo habitRepo;
    private final UserRepo userRepo;
    private final ActivityDtoMapper activityDtoMapper;

    @Autowired
    public ActivityService(ActivityRepo activityRepo, HabitRepo habitRepo, UserRepo userRepo, ActivityDtoMapper activityDtoMapper) {
        this.activityRepo = activityRepo;
        this.habitRepo = habitRepo;
        this.userRepo = userRepo;
        this.activityDtoMapper = activityDtoMapper;
    }

    public List<ActivityDto> findAll(String username) {
        return activityRepo.findAllByUserUsername(username)
                .stream()
                .map(activityDtoMapper)
                .collect(Collectors.toList());
    }

    public ActivityDto createActivity(CreateActivityDTO request, String username) {
        // Retrieve the existing habit from the database using the injected instance
        HabitModel habit = habitRepo.findById(request.habitId()).orElseThrow(
                () -> new HabitNotFoundException(request.habitId()));
        UserModel user = userRepo.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(username));

        // Create activity with existing habit
        ActivityModel activity = new ActivityModel(request.logDate(), request.title(), habit, user);
        activityRepo.save(activity);

        return activityDtoMapper.apply(activity);
    }

    @Transactional
    public ActivityModel updateActivity(Long id, UpdateActivityDTO requestBody) {
        ActivityModel activityModel = activityRepo.findById(id).orElseThrow(
                () -> new ActivityDoesNotExistException(id)
        );

        if (requestBody.title() != null)
            activityModel.setTitle(requestBody.title());

        if (requestBody.logDate() != null)
            activityModel.setLogDate(requestBody.logDate());

        return activityModel;
    }

    public void deleteActivity(Long id) {
        if (!activityRepo.existsById(id)) {
            throw new ActivityDoesNotExistException(id);
        }
        activityRepo.deleteById(id);
    }
}
